import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LowerHeaderSectionComponent } from './lower-header-section.component';

describe('LowerHeaderSectionComponent', () => {
  let component: LowerHeaderSectionComponent;
  let fixture: ComponentFixture<LowerHeaderSectionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LowerHeaderSectionComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LowerHeaderSectionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
