import { Injectable } from '@angular/core';
import {interval, Subject} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ChatScreenTalkService {

  store = new Subject<{
    chatId : string, chats : {
      message : string,
      messageTime : string,
      messageStatus : string,
      recevied : boolean
    }[]
  }>();

  deleteChat = new Subject();
  int = interval(1000);

}
