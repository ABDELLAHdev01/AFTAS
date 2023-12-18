import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TablefishesComponent } from './tablefishes.component';

describe('TablefishesComponent', () => {
  let component: TablefishesComponent;
  let fixture: ComponentFixture<TablefishesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TablefishesComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(TablefishesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
