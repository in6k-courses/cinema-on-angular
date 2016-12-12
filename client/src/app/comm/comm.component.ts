import { Component, OnInit } from '@angular/core';
import {Comm} from "./comm";
import {Router} from "@angular/router";
import {CommService} from "./comm.service";

@Component({
  moduleId: module.id.toString(),
  selector: 'my-comms',
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
    this.commService.getComms().then(comm => this.comms = comm);
  }

  ngOnInit(): void {
    this.getComms();
  }

  onSelect(comm: Comm): void {
    this.selectedMovie = comm;
  }

}
