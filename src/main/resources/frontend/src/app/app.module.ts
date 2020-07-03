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
import {DeAuthSerive} from './deauth.service'
import {} from '@angular/compiler'
import {HttpClientModule} from '@angular/common/http'
import { from } from 'rxjs';
import { Values } from './values.service';
import { CheckComponent } from './check/check.component';
const route : Route[] = [
  { path : "login" ,  component : LoginComponent},
  { path : "signup" ,  component : SignupComponent , canDeactivate : [DeAuthSerive] },
  { path : "user/check",component : CheckComponent  },
  { path : "user/:userId" , component : UserComponent   }

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
    Values
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
