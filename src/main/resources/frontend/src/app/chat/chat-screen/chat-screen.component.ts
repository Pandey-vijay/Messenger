import {Component, Input, OnChanges, OnDestroy, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {ChatScreenTalkService} from "./chat-screen-talk.service";
import {HttpClient} from "@angular/common/http";
import {Values} from "../../values.service";
import {Observable, Subscription} from "rxjs";

@Component({
  selector: 'app-chat-screen',
  templateUrl: './chat-screen.component.html',
  styleUrls: ['./chat-screen.component.css']
})

export class ChatScreenComponent implements OnInit, OnDestroy{
  userName ;
  chatInput;
  messageListener : Subscription;
  mapData : Map<number,{}> = new Map<number, {}>();

  public chats :{
    message : string,
    messageTime : string,
    messageStatus : string,
    recevied : boolean
  }[];

  constructor(private route : ActivatedRoute,
              private talk : ChatScreenTalkService,
              private http : HttpClient,
              private  values : Values) {

    route.params.subscribe(data => this.userName = data );
    talk.deleteChat.subscribe(data => {
      const chats = localStorage.getItem(this.userName["userId"]);
      if(chats) {
        this.chats = JSON.parse(chats);
      }
      else {
        console.log("null ba")
        this.chats = [];
      }
    });

    this.mapData.set(1,{});
    this.mapData.set(11,{});
    this.mapData.set(12,{});
  }

  ngOnDestroy(): void {
        this.messageListener.unsubscribe();
    }



  ngOnInit() {

    //Sends Pings to server every second to check for new Message

   this.messageListener=  this.talk.int.subscribe(data =>{
      this.http.get(`${this.values.server}/message/get/${localStorage.getItem("userId")}`)
        .subscribe(
        (data:{} ) =>{
          if(data !== null)
          {
            console.log(data)
            for (let a in data){
              this.chats.push(
                  {
                    message: data[a].message,
                    messageStatus : " ",
                    messageTime : `${new Date(data[a].sendtime).getHours()}:${new Date(data[a].sendtime).getHours()}:${new Date(data[a].sendtime).getHours()}`,
                    recevied : true
                  }
                );
            }
          }
        }
      )
    });
  }




  onSend(){
    const chatInput = this.chatInput.toString().trim();
    let message = {
      message : chatInput,
      senderId : localStorage.getItem("userId"),
      recevierId : Number.parseInt(this.userName["userId"]),
      sendTime : new Date().getTime(),
      messageId : Number.parseInt(localStorage.getItem("msgId"))+1|0
    };
    if(chatInput !== ""){
      this.http.post(`${this.values.server}/message/send`,message).subscribe(
          (data : string) => console.log(data),
        error => console.log(error)
      )

      console.log(message);
      ;
    }

    if( chatInput !== "") {
      this.chats.push({message : chatInput
        , messageTime : `${new Date().getHours()}:${new Date().getMinutes()}:${new Date().getSeconds()}`,
        messageStatus : "Sent",
        recevied : false
      });
      this.chatInput = "";
    }
    //console.log(this.chats);
    this.talk.store.next({chatId : this.userName,chats : this.chats});

    localStorage.setItem("msgId",
      (Number.parseInt(localStorage.getItem("msgId"))+1|0).toString())
  }

  onEnter(evn){

    if (evn["key"] === "Enter")
      this.onSend();

  }

}
