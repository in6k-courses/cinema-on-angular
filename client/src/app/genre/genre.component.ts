import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { Genre } from './genre';
import { GenreService } from './genre.service';

@Component({
  moduleId: module.id.toString(),
  selector: 'my-genres',
  templateUrl: 'genre.component.html',
  styleUrls: [ 'genre.component.css' ]
})
export class GenreComponent implements OnInit {
  genres: Genre[];
  selectedGenre: Genre;

  constructor(
    private router: Router,
    private genreService: GenreService) { }

  getGenres(): void {
    this.genreService.getGenres().then(genres => this.genres = genres);
  }

  ngOnInit(): void {
    this.getGenres();
  }

  onSelect(genre: Genre): void {
    this.selectedGenre = genre;
  }
  gotoDetail(){

  }
}
