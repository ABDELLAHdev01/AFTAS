import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MembermodalComponent } from './membermodal.component';

describe('MembermodalComponent', () => {
  let component: MembermodalComponent;
  let fixture: ComponentFixture<MembermodalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MembermodalComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(MembermodalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
