import { Injectable }    from '@angular/core';
import { Headers, Http } from '@angular/http';

import 'rxjs/add/operator/toPromise';

import { Movie } from './movie';

@Injectable()
export class MovieService {
  private moviesUrl = 'api/movie';
  private headers = new Headers({'Content-Type': 'application/json'});
  constructor(private http: Http) { }


  getMovies(): Promise<Movie[]> {
    return this.http.get(this.moviesUrl)
      .toPromise()
      .then(response => response.json() as Movie[])
      .catch(this.handleError);
  }

  getMovie(id: number): Promise<Movie> {
    return this.http.get(this.moviesUrl+"/"+id)
      .toPromise()
      .then(response => response.json() as Movie)
      .catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    // console.error('An error occurred', error); // for demo purposes only
    return Promise.reject(error.message || error);
  }

  create(name: string, description: string, duration: number): Promise<Movie> {
    return this.http
      .post(this.moviesUrl, JSON.stringify({name:name,description:description,duration:duration}), {headers: this.headers})
      .toPromise()
      .then(movie => movie.json())
      .catch(this.handleError);
  }

  delete(id: number): Promise<void> {
    const url = `${this.moviesUrl}/${id}`;
    return this.http
      .delete(url, {headers: this.headers})
      .toPromise()
      .then(() => null)
      .catch(this.handleError);
  }
}
