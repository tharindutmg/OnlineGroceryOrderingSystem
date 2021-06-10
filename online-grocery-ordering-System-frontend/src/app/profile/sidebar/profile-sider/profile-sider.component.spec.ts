import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfileSiderComponent } from './profile-sider.component';

describe('ProfileSiderComponent', () => {
  let component: ProfileSiderComponent;
  let fixture: ComponentFixture<ProfileSiderComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProfileSiderComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProfileSiderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
