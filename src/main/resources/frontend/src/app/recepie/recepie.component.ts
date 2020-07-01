import { Component, OnInit, Input } from '@angular/core';
import {Recepie} from "./recepie.model";

@Component({
  selector: 'app-recepie',
  templateUrl: './recepie.component.html',
  styleUrls: ['./recepie.component.css']
})
export class RecepieComponent implements OnInit {

  @Input("a-data") a : number;

  call(){
   console.log(this.a);
  } 


  constructor() {
    
   }

  ngOnInit(): void {
  }


}
