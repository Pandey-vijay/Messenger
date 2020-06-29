import { Component, OnInit } from '@angular/core';
import {Recepie} from "./recepie.model";

@Component({
  selector: 'app-recepie',
  templateUrl: './recepie.component.html',
  styleUrls: ['./recepie.component.css']
})
export class RecepieComponent implements OnInit {

  name = 'cijay';

  recepies : Recepie[]= [
    new Recepie("a",1),
    new Recepie("ab",2),
    new Recepie("ac",3)
  ];

  constructor() {
    
   }

  ngOnInit(): void {
  }

}
