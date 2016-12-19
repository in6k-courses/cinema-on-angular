import {Comm} from "../comm/comm";
export class Movie {
  movie_id: number;
  name: string;
  description: string;
  duration: number;
  comm: Comm[];
}
