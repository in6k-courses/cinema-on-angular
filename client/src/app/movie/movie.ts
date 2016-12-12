import {Comm} from "../comm/comm";
export class Movie {
  id: number;
  name: string;
  description: string;
  duration: number;
  comms: Comm[];
}
