import { Directive, OnInit,ElementRef,Renderer2 } from '@angular/core';

@Directive({
  selector: '[appLoginFeel]'
})
export class LoginFeelDirective implements OnInit {

  eventRef : ElementRef;
  render : Renderer2;
  constructor(eventRef : ElementRef,render: Renderer2) {
      this.eventRef = eventRef;
      this.render = render;
   }

  ngOnInit(){
  }

}
