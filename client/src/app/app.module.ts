import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { GenreComponent } from './genre/genre.component';
import { AppComponent } from './app.component';
import { AppRoutingModule } from "./app-routing.module";

import { HttpModule } from "@angular/http";
import { MovieComponent } from './movie/movie.component';
import {MovieService} from "./movie/movie.service";
import {GenreService} from "./genre/genre.service";
import { CommComponent } from './comm/comm.component';

@NgModule({
  declarations: [
    AppComponent,
    GenreComponent,
    MovieComponent,
    CommComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpModule
  ],
  providers: [ GenreService,MovieService ],
  bootstrap: [ AppComponent ]
})
export class AppModule { }
