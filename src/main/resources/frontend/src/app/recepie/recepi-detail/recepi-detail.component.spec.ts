import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RecepiDetailComponent } from './recepi-detail.component';

describe('RecepiDetailComponent', () => {
  let component: RecepiDetailComponent;
  let fixture: ComponentFixture<RecepiDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RecepiDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RecepiDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
