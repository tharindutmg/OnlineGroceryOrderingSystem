import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NavigationBarSectionComponent } from './navigation-bar-section.component';

describe('NavigationBarSectionComponent', () => {
  let component: NavigationBarSectionComponent;
  let fixture: ComponentFixture<NavigationBarSectionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NavigationBarSectionComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NavigationBarSectionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
