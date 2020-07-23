import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ChatStoreService {
  constructor() { }

  chats :{
    message : string,
    messageTime : number,
    messageStatus:string,
    recevied : boolean
  }[];

  storeChats(chats : {
             message : string,
             messageTime : string,
             messageStatus:string,
             recevied : boolean
           } [] ,chatId : string) {
    localStorage.setItem(chatId,chats.toString());
  }

  retriveChats(chatId){
    return localStorage.getItem(chatId);
  }
}
