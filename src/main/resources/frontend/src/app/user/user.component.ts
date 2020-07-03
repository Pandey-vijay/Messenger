import { Component, OnInit, OnChanges } from '@angular/core';
import { ActivatedRoute,Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit{
  userId : number;
  userName = "default";
  lastSeen : Date;

  constructor( private route:ActivatedRoute,private router : Router,private http : HttpClient){

  }

  ngOnInit(){
    this.route.params.subscribe(
      (data) => this.userId = data["userId"]
    );
    this.http.get(`http://localhost:8080/user/get/${this.userId}`)
    .subscribe(
      (data) => {
        this.userName = data["userName"] ;
        this.lastSeen = new Date(data["lastSeen"]);
        
      } 
    );
  }

  onClick(userId:number){
    let x = indexedDB.open("app");
    x.onsuccess = response => {
     let db = x.result;
     console.log(db);
     let data_input = db.createObjectStore("data_input",{keyPath : "input"});
      let data = data_input.add("apple");
      data.onerror = (erroe) => console.log(erroe + "11") 
    }
    this.router.navigate(["/","user",userId]);
    this.http.get(`http://localhot st:8080/user/get/${this.userId}`)
      .subscribe(
      (data) => {
        this.userName = data["userName"] ;
        this.lastSeen = new Date(data["lastSeen"]);
        
      } 
    );
  }
}