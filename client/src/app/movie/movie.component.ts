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
  selectedView : boolean;
  constructor(
    private router: Router,
    private movieService: MovieService) { }

  getMovies(): void {
    this.movieService.getMovies().then(movies => this.movies = movies);
  }

  ngOnInit(): void {
    this.getMovies();
  }

  gotoDetail(): void {
    this.router.navigate(['/detail', this.selectedMovie.id]);
  }

  onSelect(movie: Movie): void {
    this.selectedMovie = movie;
  }

  view(view: boolean):void{
    this.selectedView=!view;
  }

  add(name: string,description:string,duration:number): void {
    name = name.trim();
    if (!name) { return; }
    this.movieService.create(name,description,duration)
      .then(movie => {
        this.movies.push(movie);
        this.selectedMovie = null;
      });
  }

  delete(movie: Movie): void {
    this.movieService
      .delete(movie.id)
      .then(() => {
        this.movies = this.movies.filter(h => h !== movie);
        if (this.selectedMovie === movie) { this.selectedMovie = null; }
      });
  }
}
