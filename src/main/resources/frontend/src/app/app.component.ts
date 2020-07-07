import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Messenger';

  showLogin() : boolean{
    if(localStorage.getItem("authId") === null)
      return true;
    else
      return false;
  }

  onClick(){
    localStorage.removeItem("userId");
    localStorage.removeItem("authId");
    localStorage.removeItem("timeStamp");
  }
}
