import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ActivatedRoute, Router} from "@angular/router";
import {relative} from "path";
import {relativeToRootDirs} from "@angular/compiler-cli/src/transformers/util";

@Component({
  selector: 'app-chat',
  templateUrl: './chat.component.html',
  styleUrls: ['./chat.component.css']
})
export class ChatComponent implements OnInit {
  @ViewChild("templateRef") chatSceen : ElementRef ;
  users : string[] = ["vijay","ajay","abhay","anuj","kamal"]

  constructor( private http : HttpClient,private router : Router,private route : ActivatedRoute) { }

  ngOnInit(): void {
  }

  onClick(user){
  this.router.navigate([`${user}`],{relativeTo:this.route,});
  }
}
