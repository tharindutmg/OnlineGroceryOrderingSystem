import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpperHeaderSectionComponent } from './upper-header-section.component';

describe('UpperHeaderSectionComponent', () => {
  let component: UpperHeaderSectionComponent;
  let fixture: ComponentFixture<UpperHeaderSectionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpperHeaderSectionComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpperHeaderSectionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
