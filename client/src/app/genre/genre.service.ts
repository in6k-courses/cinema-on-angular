import { Injectable }    from '@angular/core';
import { Headers, Http } from '@angular/http';

import 'rxjs/add/operator/toPromise';

import { Genre } from './genre';

@Injectable()
export class GenreService {
  private genreUrl = '/api/genre';
  private headers = new Headers({'Content-Type': 'application/json'});
  constructor(private http: Http) { }


  getGenres(): Promise<Genre[]> {
    return this.http.get(this.genreUrl)
      .toPromise()
      .then(response => response.json() as Genre[])
      .catch(this.handleError);
  }

  getGenre(id: number): Promise<Genre> {
    return this.getGenres()
      .then(genres => genres.find(genre => genre.id === id));
  }

  private handleError(error: any): Promise<any> {
    // console.error('An error occurred', error); // for demo purposes only
    return Promise.reject(error.message || error);
  }

  create(name: string) {
    return this.http
      .post(this.genreUrl, JSON.stringify({name:name}), {headers: this.headers})
      .toPromise()
      .then(genre => genre.json())
      .catch(this.handleError);
  }
}
