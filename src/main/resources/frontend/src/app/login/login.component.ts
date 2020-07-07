import { Component, OnInit, Input, Output, EventEmitter, OnDestroy, ViewChild } from '@angular/core';
import {HttpClient} from '@angular/common/http'
import { NgForm } from '@angular/forms';
import {Values} from '../values.service';
import {Router} from '@angular/router'
import {retry} from "rxjs/operators";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  providers:[Values]
})

export class LoginComponent  {
  @ViewChild("form") form : NgForm;
  userData : {userId:number ,pass : string};
  failed = false;
  constructor(private http : HttpClient,private values : Values,private router : Router){
    console.log("aa");
  }

  onLogin(){
    this.http.get(`${this.values.server}/user/login`,{params : {"userId":this.form.value["userId"],"pass" : this.form.value["pass"]}}).subscribe(
      response => {
          if(response === null)
            alert(`Login Failed`)
        else {
            console.log(this.form.value["userId"]);
            localStorage.setItem("userId",this.form.value["userId"]);
            localStorage.setItem("authId",response.toString());
            localStorage.setItem("timeStamp",new Date().getTime().toString());
            alert("login Success");
          }
      }
    )
  }

  onSignUp(){
  this.router.navigate(["/","signup"]).catch(error => console.log(error));
  }

}
