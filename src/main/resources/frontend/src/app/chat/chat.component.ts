import {Component, ElementRef, OnInit, Output, ViewChild} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ActivatedRoute, Router} from "@angular/router";
import {relative} from "path";
import {relativeToRootDirs} from "@angular/compiler-cli/src/transformers/util";
import {ChatStoreService} from "./chat-store.service";
import {ChatScreenComponent} from "./chat-screen/chat-screen.component";
import {ChatScreenTalkService} from "./chat-screen/chat-screen-talk.service";

@Component({
  selector: 'app-chat',
  templateUrl: './chat.component.html',
  styleUrls: ['./chat.component.css'],

})
export class ChatComponent implements OnInit {
  @ViewChild('chatScreen') chatScreen : ChatScreenComponent;
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
  constructor( private http : HttpClient,private router : Router,private route : ActivatedRoute,private talk : ChatScreenTalkService) {
    talk.store.subscribe((data) => {
      localStorage.setItem(data.chatId["userId"],JSON.stringify(data.chats));
      }
    )
  }

  ngOnInit(): void {

  }

    onClick(user){
    this.talk.deleteChat.next();
    this.router.navigate([`${user}`],{relativeTo:this.route});
  }
}
