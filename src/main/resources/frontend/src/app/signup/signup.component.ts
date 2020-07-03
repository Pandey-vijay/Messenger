import { Component, OnInit, ViewChild } from '@angular/core';
import { DeAuthSerive } from '../deauth.service';
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

  userData : {userId : number,userName : string,pass: string} ;
  constructor(private http : HttpClient){

  }
  
  ngOnInit(): void {

  }

  onSubmit(){
    
    this.userData = {
      userId : 2,
      userName : this.form.value.userName,
      pass : this.form.value.password
    }

    console.log(this.userData);
  
    this.http.post("http://localhost:8080/user/add",this.userData).subscribe(
    (response)=> console.log(response),
    (error) => console.log(error)
    );

  }
}
