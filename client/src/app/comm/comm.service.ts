import {Injectable}    from '@angular/core';
import {Headers, Http} from '@angular/http';

import 'rxjs/add/operator/toPromise';
import {Comm} from "./comm";


@Injectable()
export class CommService {
  private commUrl = '/api/comm';
  private headers = new Headers({'Content-Type': 'application/json'});

  constructor(private http: Http) {
  }


  getComms(): Promise<Comm[]> {
    return this.http.get(this.commUrl)
      .toPromise()
      .then(response => response.json() as Comm[])
      .catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    // console.error('An error occurred', error); // for demo purposes only
    return Promise.reject(error.message || error);
  }

  createComm(like: number, movie_id: number): Promise<Comment> {
    // alert("" + like + "!" + movie_id + "!");
    return this.http
      .post(this.commUrl, JSON.stringify({like: like, movie_id: movie_id}), {headers: this.headers})
      .toPromise()
      .then(comm => comm.json())
      .catch(this.handleError);
  }

}
