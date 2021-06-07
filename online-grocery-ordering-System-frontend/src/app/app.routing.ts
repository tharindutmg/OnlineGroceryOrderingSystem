import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
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
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path:  'home', component:  HomeComponent},
  { path:  'registration', component:  RegistrationComponent},
  { path:  'login', component:  LoginComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
