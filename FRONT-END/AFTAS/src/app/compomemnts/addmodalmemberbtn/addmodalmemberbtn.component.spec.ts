import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddmodalmemberbtnComponent } from './addmodalmemberbtn.component';

describe('AddmodalmemberbtnComponent', () => {
  let component: AddmodalmemberbtnComponent;
  let fixture: ComponentFixture<AddmodalmemberbtnComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AddmodalmemberbtnComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AddmodalmemberbtnComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
