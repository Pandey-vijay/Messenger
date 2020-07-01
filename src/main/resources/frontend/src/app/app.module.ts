import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HeaderComponent} from './header/header.component';
import { RecepieComponent } from './recepie/recepie.component';
import { RecepiListComponent } from './recepie/recepi-list/recepi-list.component';
import { RecepiDetailComponent } from './recepie/recepi-detail/recepi-detail.component'
import { FormsModule } from '@angular/forms';
import { MyStyleDirective } from './my-style.directive'

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    RecepieComponent,
    RecepiListComponent,
    RecepiDetailComponent,
    MyStyleDirective
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
