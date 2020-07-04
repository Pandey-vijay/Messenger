import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Values } from '../values.service';

@Component({
  selector: 'app-check',
  templateUrl: './check.component.html',
  styleUrls: ['./check.component.css']
})
export class CheckComponent implements OnInit {

  userId : number = 0 ;
  constructor(private http : HttpClient,private values : Values) {}

  ngOnInit(): void {
    
  }

  onClick(){
    this.http.get(`${this.values.server}/user/check`,{
      params :{
        "userId":`${this.userId}`,
        "authId":localStorage.getItem("auth") 
      }}).subscribe(
        (data) => console.log(data)
      );
  }

}
