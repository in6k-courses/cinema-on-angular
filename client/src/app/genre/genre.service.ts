import { Injectable }    from '@angular/core';
import { Headers, Http } from '@angular/http';

import 'rxjs/add/operator/toPromise';

import { Genre } from './genre';

@Injectable()
export class GenreService {
  private genreUrl = '/api/genre/';
  private headers = new Headers({'Content-Type': 'application/json'});
  constructor(private http: Http) { }


  getGenres(): Promise<Genre[]> {
    return this.http.get(this.genreUrl)
      .toPromise()
      .then(response => response.json() as Genre[])
      .catch(this.handleError);

  }

  getGenre(genreId: number): Promise<Genre> {
    return this.getGenres()
      .then(genres => genres.find(genre => genre.id === genreId));
  }

  update(list: Genre): Promise<Genre> {
    const url = `${this.genreUrl}/${list.id}`;
    return this.http
      .put(url, list, {headers: this.headers})
      .toPromise()
      .then(() => list)
      .catch(this.handleError);
  }

  create(listName: string): Promise<Genre> {
    return this.http
      .put(this.genreUrl, JSON.stringify({listName: listName}), {headers: this.headers})
      .toPromise()
      .then(res => res.json())
      .catch(this.handleError);
  }

  delete(idList: number): Promise<void> {
    const url = `${this.genreUrl}/${idList}`;
    return this.http.delete(url, {headers: this.headers})
      .toPromise()
      .then(() => null)
      .catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error); // for demo purposes only
    return Promise.reject(error.message || error);
  }

}
