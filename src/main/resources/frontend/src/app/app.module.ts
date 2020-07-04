import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import {FormsModule} from "@angular/forms";
import { LoginFeelDirective } from './login/login-feel.directive'
import {Route, RouterModule,ActivatedRoute} from "@angular/router";
import { UserComponent } from './user/user.component'
import {} from '@angular/compiler'
import {HttpClientModule} from '@angular/common/http'
import { from } from 'rxjs';
import { Values } from './values.service';
import { CheckComponent } from './check/check.component';
import  {LoginAuthGaurdService} from "./login-auth-gaurd.service"
const route : Route[] = [
  { path : "login" ,  component : LoginComponent},
  { path : "signup" ,  component : SignupComponent  },
  { path : "user/check",component : CheckComponent,canActivate : [LoginAuthGaurdService]},
  { path : "user/:userId" , component : UserComponent,canActivate : [LoginAuthGaurdService]}
  ]


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SignupComponent,
    LoginFeelDirective,
    UserComponent,
    CheckComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(route)
  ],
  providers: [
    Values,LoginAuthGaurdService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
