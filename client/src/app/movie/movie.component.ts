import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { Movie } from './movie';
import { MovieService } from './movie.service';

@Component({
  moduleId: module.id.toString(),
  selector: 'my-movies',
  templateUrl: 'movie.component.html',
  styleUrls: [ 'movie.component.css' ]
})
export class MovieComponent implements OnInit {
  movies: Movie[];
  selectedMovie: Movie;

  constructor(
    private router: Router,
    private movieService: MovieService) { }

  getMovies(): void {
    this.movieService.getMovies().then(movies => this.movies = movies);
  }

  ngOnInit(): void {
    this.getMovies();
  }

  onSelect(movie: Movie): void {
    this.selectedMovie = movie;
  }
}
