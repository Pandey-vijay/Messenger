import { Directive, ElementRef, OnInit, Renderer2 } from '@angular/core';

@Directive({
  selector: '[appMyStyle]'
})
export class MyStyleDirective implements OnInit {

  data: ElementRef;
  render : Renderer2;
  constructor(data : ElementRef,render :Renderer2) {
    this.data = data;
    this.render = render;
   }

  ngOnInit(){
    this.render.setStyle(this.data.nativeElement,"background-color","blue");
    this.render. 
  };
}
