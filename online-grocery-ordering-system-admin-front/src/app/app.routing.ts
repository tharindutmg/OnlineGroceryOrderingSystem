import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ApplicationComponent } from './application/application.component';
import { RouteGuardService } from './auth/route-guard.service';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { NavigationComponent } from './navigation/navigation.component';
import { NotLoginComponent } from './not-login/not-login.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { RegistrationComponent } from './registration/registration.component';
import { RoleComponent } from './role/role.component';
import { UserAppComponent } from './user-app/user-app.component';
import { UserRolesComponent } from './user-roles/user-roles.component';

/* const appRoutes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: '', component: MainComponent, redirectTo: '/dashboard', pathMatch: 'full',
    children: [
      { path: 'alert/:id', component: AlertDetailComponent },
      { path: 'alerts', component: AlertsComponent },
      { path: 'dashboard', component: EriskDashboardComponent }
  ]}]; */


const routes: Routes = [
  /* { path: '', redirectTo: '/login', pathMatch: 'full' }, */
  /* { path: 'view-report', redirectTo: '/report' }, */
  { path:  'login', component:  LoginComponent},
  { path:  'register', component:  RegistrationComponent},

  {path: '', component: NavigationComponent,
  children: [
  {
    path: '',
    redirectTo: 'home',
    pathMatch: 'full'
  },
  { path:  'home', component:  HomeComponent,
    canActivate : [RouteGuardService],
    data: {
      allowedRoles: ['ROLE_ADMIN']
    }
  },
  { path:  'user-role',
    component:  UserRolesComponent,
    canActivate : [RouteGuardService],
    data: {
      allowedRoles: ['ROLE_ADMIN']
    }},
  { path:  'role', 
    component:  RoleComponent,
    canActivate : [RouteGuardService],data: {
    allowedRoles: ['ROLE_ADMIN']
  }},
  { path:  'app', 
    component:  ApplicationComponent,
    canActivate : [RouteGuardService],data: {
    allowedRoles: ['ROLE_ADMIN']
  }},
  { path:  'user-app', 
    component:  UserAppComponent,
    canActivate : [RouteGuardService],data: {
    allowedRoles: ['ROLE_ADMIN']
  }},
  { path:  'application', 
    component:  ApplicationComponent,
    canActivate : [RouteGuardService],data: {
    allowedRoles: ['ROLE_ADMIN']
  }},
  { path:  'accessdenied', component:  NotLoginComponent},
  { path: '**', component: PageNotFoundComponent }, 
  
  
]}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
