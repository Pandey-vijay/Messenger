import { Injectable } from '@angular/core';
import {ActivatedRoute} from "@angular/router";

interface Message {

  message : string;
  sendtime? : number,
  senderId? : number,
  recevierId : number,
  messageId? : number,
  recTime? : number,
  seenTime? : number

}

@Injectable()
export class LoadChatService {

  messages : Message[];
  constructor( private activeRoute : ActivatedRoute) {
  }

  load(userId : number) : Message[]{

    this.messages = JSON.parse(localStorage.getItem(userId.toString()));

    if(this.messages)
      return this.messages;
    else
      return [];
  }

  getStatus() : string {
      return "Sent";
  }

  store(message:Message){

    console.log(message);
    this.messages = JSON.parse(localStorage.getItem(message.recevierId.toString()));

    if(this.messages) {
      this.messages.push(message);
    }
    else{
      this.messages = [];
      this.messages.push(message);
    }

    let messagesString = JSON.stringify(this.messages);
    localStorage.setItem(message.recevierId.toString(),messagesString);
    console.log(this.messages)
  }

  storeAll(messages : Message[]){
    let messagesToString = JSON.stringify(messages);
    localStorage.setItem(messages[0].recevierId.toString(),messagesToString);
  }

  updateMessage(message : Message,tempId : number){
    let chats : Message[] = this.load(message.recevierId);

    const i =  chats.findIndex( msg =>{
      if(msg.messageId === tempId)
        return msg;
    }  );

    chats[i] = message;

    this.storeAll(chats);
  }

  appendMessage(messages : Message[],userId : number){
    let chats : Message[] = this.load(userId);
    chats = chats.concat(messages);
    let messagesToString = JSON.stringify(chats);
    localStorage.setItem(userId.toString(),messagesToString);
  }

}
