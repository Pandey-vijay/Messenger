import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http'
import {Values} from "../values.service";
import {LoadChatService} from "./chat-screen/load-chat.service";

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
export class ServerCommunicationService {

  currentUser = localStorage.getItem("userId");

  constructor(  private http : HttpClient,
                private values : Values,
                private loadChat : LoadChatService) {

  }

  send(messageData : string,recevierID : number,tempId : number){

    let message : Message = {

      message : messageData,
      sendtime : new Date().getTime(),
      senderId : +localStorage.getItem("userId"),
      recevierId : recevierID,
      messageId : tempId
    }

    let a = this.http.post(`${this.values.server}/message/send`,message).subscribe(
      (messageId : number) =>{
       message.messageId = messageId;
       this.loadChat.updateMessage(message,tempId);
      }
    );

  }

  recevie() {
    this.http.get(`${this.values.server}/message/get/${this.currentUser}`).subscribe(
      (data:Message[]|null) =>{
        if(data){
          if (data[0]) {
            {
              this.loadChat.appendMessage(data, data[0].senderId);
            }
          }
        }
      }
    )
  }

}
