import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app.routing';
import { HomeComponent } from './home/home.component';
import { FooterComponent } from './template/footer/footer.component';
import { UpperHeaderSectionComponent } from './template/upper-header-section/upper-header-section.component';
import { LowerHeaderSectionComponent } from './template/lower-header-section/lower-header-section.component';
import { NavigationBarSectionComponent } from './template/navigation-bar-section/navigation-bar-section.component';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { NavigationService } from './template/navigation-bar-section/service/navigation.service';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { RegistrationComponent } from './registration/registration.component';
import { SidebarComponent } from './template/sidebar/sidebar.component';
import { LoginComponent } from './login/login.component';
import { RegistrationService } from './registration/service/registration.service';
import { ToastrModule } from 'ngx-toastr';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    FooterComponent,
    UpperHeaderSectionComponent,
    LowerHeaderSectionComponent,
    NavigationBarSectionComponent,
    RegistrationComponent,
    SidebarComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    CommonModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    ToastrModule.forRoot(),
  ],
  providers: [NavigationService,RegistrationService],
  bootstrap: [AppComponent]
})
export class AppModule { }
