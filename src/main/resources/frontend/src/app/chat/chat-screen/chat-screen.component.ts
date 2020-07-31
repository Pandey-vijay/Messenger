import {Component, Input, OnChanges, OnDestroy, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {ChatScreenTalkService} from "./chat-screen-talk.service";
import {HttpClient} from "@angular/common/http";
import {Values} from "../../values.service";
import {Observable, Subscription} from "rxjs";
import {LoadChatService} from "./load-chat.service";
import {ServerCommunicationService} from "../server-communication.service";

interface Message {

  message : string;
  sendtime? : number,
  senderId? : number,
  recevierId? : number,
  messageId? : number,
  recTime? : number,
  seenTime? : number

}

@Component({
  selector: 'app-chat-screen',
  templateUrl: './chat-screen.component.html',
  styleUrls: ['./chat-screen.component.css'],
  providers : [LoadChatService,ServerCommunicationService]
})

export class ChatScreenComponent implements OnInit, OnDestroy{
  @Input() data;
  currentUser : number = +localStorage.getItem("userId") ;
  chatInput = "";
  screenUpdateListener : Subscription;
  chatUpdate : Subscription;
  userId : number = 0;

  public chats : Message[] = this.loadChat.load(this.userId);

  constructor(private route : ActivatedRoute,
              private talk : ChatScreenTalkService,
              private http : HttpClient,
              private values : Values,
              private loadChat : LoadChatService,
              private serverCommunication : ServerCommunicationService) {
    this.route.params.subscribe( data => this.userId = data["userId"] );
  }

  ngOnDestroy(): void {

    console.log("destroy");
    this.screenUpdateListener.unsubscribe()
  }



  ngOnInit() {

    this.chats = this.loadChat.load(this.userId);

    this.screenUpdateListener = this.talk.updateChatScreen.subscribe(
      (userId : number) => {

        this.chats = this.loadChat.load(userId);

      }
    );

    this.chatUpdate = this.talk.int.subscribe(
      data => {
        this.chats = this.loadChat.load(this.userId);
      }
    )

  }

  statusResolve(msg : Message) : string{
    let op = "imp";
    if(msg.messageId < 0)
      op = "Sending";
    if(msg.messageId > 0)
      op =  "Sent";
    if(msg.recTime > 0)
      op =  "Recived";
    if(msg.seenTime > 0)
      op = "Seen"
    return op;
  }

  timeResolver (time : number) : string {
    return `${new Date(time).getHours()}:${new Date(time).getMinutes()}`;
  }

  onSend(){
    this.chatInput = this.chatInput.toString().trim();
    let temp = --this.values.tempId;
    if(this.chatInput !== ""){
      this.serverCommunication.send(this.chatInput,this.userId,temp);
      this.loadChat.store({message : this.chatInput,recevierId : this.userId,messageId : temp,senderId : this.currentUser,sendtime : new Date().getTime()});
    }
    this.chats = this.loadChat.load(this.userId);
    this.chatInput = "";
  }


  onEnter(evn){

    if (evn["key"] === "Enter")
      this.onSend();

  }

}
