import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RecepiListComponent } from './recepi-list.component';

describe('RecepiListComponent', () => {
  let component: RecepiListComponent;
  let fixture: ComponentFixture<RecepiListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RecepiListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RecepiListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
