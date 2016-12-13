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
  selectedView : boolean;

  constructor(
    private router: Router,
    private genreService: GenreService) { }

  getGenres(): void {
    this.genreService.getGenres().then(genre => this.genres = genre);
  }

  ngOnInit(): void {
    this.getGenres();
  }

  onSelect(genre: Genre): void {
    this.selectedGenre = genre;
  }
  view(view: boolean):void{
    this.selectedView=!view;
  }
  add(name: string): void {
    name = name.trim();
    if (!name) { return; }
    this.genreService.create(name)
      .then(genre => {
        this.genres.push(genre);
        this.selectedGenre = null;
      });
  }
  delete(genre : Genre): void {
    this.genreService
      .delete(genre.id)
      .then(() => {
        this.genres = this.genres.filter(h => h !== genre);
        if (this.selectedGenre === genre) { this.selectedGenre = null; }
      });
  }
}
