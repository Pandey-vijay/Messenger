import { Component, OnInit, Input, Output, EventEmitter, OnDestroy, ViewChild } from '@angular/core';
import {HttpClient} from '@angular/common/http'
import { NgForm } from '@angular/forms';
import {Values} from '../values.service'
import { from } from 'rxjs';
import { isNull } from '@angular/compiler/src/output/output_ast';


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
constructor(private http : HttpClient,private values : Values){}

onLogin(){
  this.userData = {
    userId : this.form.value.userId,
    pass : this.form.value.pass
  }

  this.http.get(`${this.values.server}/user/login`,
  {params : {"userId":this.userData.userId.toString(),"pass":this.userData.pass}}).
  subscribe(
    (data)=>{
      if(data !== null)
      {
        localStorage.setItem("authId",data.toString());
        localStorage.setItem("userId",this.userData.userId.toString());
      }
      else
      {
        console.log("login fail");
        this.failed = true;
      }
    }
  );

}

}
