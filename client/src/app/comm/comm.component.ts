import { Component, OnInit } from '@angular/core';
import {Comm} from "./comm";
import {Router} from "@angular/router";
import {CommService} from "./comm.service";

@Component({
  selector: 'app-comm',
  templateUrl: './comm.component.html',
  styleUrls: ['./comm.component.css']
})
export class CommComponent implements OnInit {

  comms: Comm[];
  selectedMovie: Comm;

  constructor(
    private router: Router,
    private commService: CommService) { }

  getComms(): void {
    this.commService.getComms().then(comms => this.comms = comms);
  }

  ngOnInit(): void {
    this.getComms();
  }

  onSelect(comm: Comm): void {
    this.selectedMovie = comm;
  }

}
