import {Component, OnInit, Pipe, ViewChild} from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import {AbstractControl, FormControl, FormGroup, NgForm, NgModel, ValidatorFn, Validators} from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { from } from 'rxjs';
import {ValidateFn} from "codelyzer/walkerFactory/walkerFn";
import {Values} from "../values.service";
import {error} from "@angular/compiler/src/util";
import {map} from "rxjs/operators";
import {strict} from "assert";

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css'],
  providers : [Values]
})
export class SignupComponent implements OnInit {

  signupForm : FormGroup;
  constructor(private http : HttpClient ,private router :Router,private values : Values) {

  }

  ngOnInit() {
    this.signupForm = new FormGroup({

      "userId" : new FormControl(null,[Validators.required],
        [this.checkId.bind(this)]),
      "userName" : new FormControl(null,[Validators.required]),
      "password" : new FormControl(null,[Validators.required]),
      "cpassword" : new FormControl(null,[Validators.required,this.isEqual])

    })
  }

  isEqual(control : AbstractControl) {
    const v1 = control.value;
    const v2 = control.root.get("password");
    if(v2)
    {
      if(v1 === v2.value)
        return null;
      else
      return {isError : "not same as password"}
    }
  }



  checkId(control : AbstractControl) {
   return  this.http.get(`${this.values.server}/user/check`,{params : {"userId":control.value}}).pipe(
      map(value => {
        if (value)
         return  null
        else
          return {isError : "Id not available"}
      } )
    )
  }
  onSubmit(){
    this.http.post(`${this.values.server}/user/add`,this.signupForm.value).subscribe(
      (response : {userId : string, authId : string, timeStamp:number}) =>{
        alert(
          `user Id : ${response.userId} \n
          authId : ${response.authId} \n
          timeStamp : ${response.timeStamp}`
        )
      }
      )

    console.log(this.signupForm.value);
  }

  onLoginBtn(){
    this.router.navigate(["/","login"]);
  }
}
