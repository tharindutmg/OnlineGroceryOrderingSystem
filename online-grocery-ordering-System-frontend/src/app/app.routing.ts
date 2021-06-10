import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { MainTemplateComponent } from './main-template/main-template.component';
import { AddressBookComponent } from './profile/address-book/address-book.component';
import { ProfileComponent } from './profile/profile.component';
import { ProfileSiderComponent } from './profile/sidebar/profile-sider/profile-sider.component';
import { RegistrationComponent } from './registration/registration.component';


/* const appRoutes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: '', component: MainComponent, redirectTo: '/dashboard', pathMatch: 'full',
    children: [
      { path: 'alert/:id', component: AlertDetailComponent },
      { path: 'alerts', component: AlertsComponent },
      { path: 'dashboard', component: EriskDashboardComponent }
  ]}]; */


const routes: Routes = [
  /* { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path:  'home', component:  HomeComponent},
  { path:  'registration', component:  RegistrationComponent},
  { path:  'login', component:  LoginComponent},
  { path:  'profile', component:  ProfileComponent},
  { path:  'address-book', component:  AddressBookComponent}, */
  

  {path: '', component: MainTemplateComponent,
    children: [
    /* { path:  'login', component:  LoginComponent},
    { path:  'register', component:  RegistrationComponent}, */
    {
      path: '',
      redirectTo: 'home',
      pathMatch: 'full'
    },
    { path:  'home', 
      component:  HomeComponent,
      /* canActivate : [RouteGuardService],
      data: {
        allowedRoles: ['ROLE_ADMIN']
      } */
    },
    { path:  'registration',
      component:  RegistrationComponent,
      /* canActivate : [RouteGuardService],
      data: {
        allowedRoles: ['ROLE_ADMIN']
      } */},
    { path:  'login', 
      component:  LoginComponent,
      /* canActivate : [RouteGuardService],data: {
      allowedRoles: ['ROLE_ADMIN']
    } */},
    { path:  'profile', component:  ProfileComponent},
  { path:  'address-book', component:  AddressBookComponent}
    /* { path:  'profile', 
      component:  ProfileComponent, */
    /*  canActivate : [RouteGuardService],data: {
      allowedRoles: ['ROLE_ADMIN']
    } *///},
    /* { path:  'user-app', 
      component:  UserAppComponent,
      canActivate : [RouteGuardService],data: {
      allowedRoles: ['ROLE_ADMIN']
    }},
    { path:  'application', 
      component:  ApplicationComponent,
      canActivate : [RouteGuardService],
      data: {
      allowedRoles: ['ROLE_ADMIN']
    }},
    { path:  'accessdenied', component:  NotLoginComponent},
    { path: '**', component: PageNotFoundComponent },  */
    
    
  ]},
 /*  {path: '', component: ProfileSiderComponent,
  children: [{
    path: '',
    redirectTo: 'profile',
    pathMatch: 'full'
  },
  { path:  'profile', component:  ProfileComponent},
  { path:  'address-book', component:  AddressBookComponent}]

}, */

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
