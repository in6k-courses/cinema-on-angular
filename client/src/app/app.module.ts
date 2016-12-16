import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { GenreComponent } from './genre/genre.component';
import { AppComponent } from './app.component';
import { AppRoutingModule } from "./app-routing.module";
import { AlertModule } from 'ng2-bootstrap/ng2-bootstrap';

import { HttpModule } from "@angular/http";
import { MovieComponent } from './movie/movie.component';
import {MovieService} from "./movie/movie.service";
import {GenreService} from "./genre/genre.service";
import { CommComponent } from './comm/comm.component';
import {CommService} from "./comm/comm.service";
import { DescrComponent } from './descr/descr.component';
import { AddNewMovieComponent } from './add-new-movie/add-new-movie.component';
import { AddNewGenreComponent } from './add-new-genre/add-new-genre.component';

@NgModule({
  declarations: [
    AppComponent,
    GenreComponent,
    MovieComponent,
    CommComponent,
    DescrComponent,
    AddNewMovieComponent,
    AddNewGenreComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpModule,
    AlertModule
  ],
  providers: [ GenreService,MovieService,CommService],
  bootstrap: [ AppComponent ]
})
export class AppModule { }
