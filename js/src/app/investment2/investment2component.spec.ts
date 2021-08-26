import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Investment2Component } from './investment2.component';

describe('Investment2Component', () => {
  let component: Investment2Component;
  let fixture: ComponentFixture<Investment2Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ Investment2Component ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(Investment2Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
