import {Component, ElementRef, OnDestroy, OnInit, Output, ViewChild} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ActivatedRoute, Router} from "@angular/router";
import {relative} from "path";
import {relativeToRootDirs} from "@angular/compiler-cli/src/transformers/util";
import {ChatStoreService} from "./chat-store.service";
import {ChatScreenComponent} from "./chat-screen/chat-screen.component";
import {ChatScreenTalkService} from "./chat-screen/chat-screen-talk.service";
import {Subscription} from "rxjs";
import {Values} from "../values.service";
import {ServerCommunicationService} from "./server-communication.service";
import {LoadChatService} from "./chat-screen/load-chat.service";


@Component({
  selector: 'app-chat',
  templateUrl: './chat.component.html',
  styleUrls: ['./chat.component.css'],
  providers : [ServerCommunicationService,LoadChatService]
})
export class ChatComponent implements OnInit, OnDestroy {
  @ViewChild('chatScreen') chatScreen : ChatScreenComponent;

  messageListener : Subscription;
  userID = localStorage.getItem("userId");
  users : {userId : number,userName : string}[] = [
    {
      userId : 1,
      userName : 'Vijay'
    },
    {
      userId : 11,
      userName : "ajay"
    }
  ];
  constructor( private http : HttpClient,
               private router : Router,
               private route : ActivatedRoute,
               private talk : ChatScreenTalkService,
               private values : Values,
               private serverCommunication : ServerCommunicationService) {
    talk.store.subscribe((data) => {
      localStorage.setItem(data.chatId["userId"],JSON.stringify(data.chats));
      }
    )
  }

  ngOnDestroy(): void {

    }

  ngOnInit(): void {
    this.messageListener = this.talk.int.subscribe(
      data => {
        this.serverCommunication.recevie();
      }
    );
  }



  onClick(user){

    this.talk.updateChatScreen.next(user);
    this.router.navigate([`${user}`],{relativeTo:this.route});

  }
}
