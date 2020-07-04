import { Component, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { NgForm } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { from } from 'rxjs';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})


export class SignupComponent implements OnInit {
  @ViewChild("form") form:NgForm;

  userData : {userName : string,pass: string} ;
  constructor(private http : HttpClient,private router : Router){

  }

  ngOnInit(): void {

  }

  onSubmit(){

    this.userData = {
      userName : this.form.value.userName,
      pass : this.form.value.password
    }

    this.http.post("http://localhost:8080/user/add",this.userData).subscribe(
    (response:{userId:number,authId:string,timeStamp:number})=> {
      console.log(response);
      localStorage.setItem("userId",response.userId.toString());
      localStorage.setItem("authId",response.authId.toString());
      localStorage.setItem("timeStamp",response.timeStamp.toString());
      this.router.navigate(['/','user',response.userId]).catch(error => console.log(error));
    },
    (error) => console.log(error)
    );

  }


}
