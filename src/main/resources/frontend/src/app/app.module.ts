import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HeaderComponent} from './header/header.component';
import { RecepieComponent } from './recepie/recepie.component';
import { RecepiListComponent } from './recepie/recepi-list/recepi-list.component';
import { RecepiDetailComponent } from './recepie/recepi-detail/recepi-detail.component'

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    RecepieComponent,
    RecepiListComponent,
    RecepiDetailComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
