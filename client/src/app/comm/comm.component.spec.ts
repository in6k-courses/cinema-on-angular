/* tslint:disable:no-unused-variable */
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';

import { CommComponent } from './comm.component';

describe('CommComponent', () => {
  let component: CommComponent;
  let fixture: ComponentFixture<CommComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CommComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CommComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
