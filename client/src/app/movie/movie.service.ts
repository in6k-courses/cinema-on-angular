import { Injectable }    from '@angular/core';
import { Headers, Http } from '@angular/http';

import 'rxjs/add/operator/toPromise';

import { Movie } from './movie';

@Injectable()
export class MovieService {
  private heroesUrl = '/api/film/';
  private headers = new Headers({'Content-Type': 'application/json'});
  constructor(private http: Http) { }


  getMovies(): Promise<Movie[]> {
    return this.http.get(this.heroesUrl)
      .toPromise()
      .then(response => response.json() as Movie[])
      .catch(this.handleError);
  }

  getFilm(id: number): Promise<Movie> {
    return this.getMovies()
      .then(films => films.find(film => film.id === id));
  }

  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error); // for demo purposes only
    return Promise.reject(error.message || error);
  }

}
