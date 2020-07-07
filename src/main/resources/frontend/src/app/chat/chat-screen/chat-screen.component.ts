import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-chat-screen',
  templateUrl: './chat-screen.component.html',
  styleUrls: ['./chat-screen.component.css']
})
export class ChatScreenComponent implements OnInit {
  userName ;
  chatInput;
  chats :{message : string, messageTime : string, messageStatus : string} [] = [
    {message : "hello", messageTime : `${new Date().getHours()}:${new Date().getMinutes()}:${new Date().getSeconds()}`,messageStatus : "Delivered" }
  ]
  constructor(private route : ActivatedRoute) {

  }

  ngOnInit() {
    this.userName = this.route.params.subscribe(data => {
      this.userName = data["userId"]
    });
  }

  onSend(){
    const chatInput = this.chatInput.toString().trim();
    if( chatInput !== "") {
      this.chats.push({message : chatInput, messageTime : `${new Date().getHours()}:${new Date().getMinutes()}:${new Date().getSeconds()}`,messageStatus : "Sent"});
      this.chatInput = "";
    }
  }
}
