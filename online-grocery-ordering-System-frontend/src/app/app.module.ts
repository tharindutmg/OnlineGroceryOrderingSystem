import { CommonModule } from '@angular/common';
import { ErrorHandler, NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app.routing';
import { HomeComponent } from './home/home.component';
import { FooterComponent } from './template/footer/footer.component';
import { UpperHeaderSectionComponent } from './template/upper-header-section/upper-header-section.component';
import { LowerHeaderSectionComponent } from './template/lower-header-section/lower-header-section.component';
import { NavigationBarSectionComponent } from './template/navigation-bar-section/navigation-bar-section.component';
import { HttpClient, HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { NavigationService } from './template/navigation-bar-section/service/navigation.service';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { RegistrationComponent } from './registration/registration.component';
import { SidebarComponent } from './template/sidebar/sidebar.component';
import { LoginComponent } from './login/login.component';
import { RegistrationService } from './registration/service/registration.service';
import { ToastrModule } from 'ngx-toastr';
import { ProfileComponent } from './profile/profile.component';
import { ProfileSiderComponent } from './profile/sidebar/profile-sider/profile-sider.component';
import { AddressBookComponent } from './profile/address-book/address-book.component';
import { AddressBookService } from './profile/address-book/service/address-book.service';
import { BasicAuthInterceptor } from './auth/basic-auth.interceptor';
import { UserDetailsCommonService } from './common/user-details-common.service';
import { GlobalErrorHandlerService } from './auth/global-error-handler.service';
import { MainTemplateComponent } from './main-template/main-template.component';
import { ModalModule } from 'ngx-bootstrap/modal';

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
    LoginComponent,
    ProfileComponent,
    ProfileSiderComponent,
    AddressBookComponent,
    MainTemplateComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    CommonModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    ModalModule.forRoot(),
    ToastrModule.forRoot(),
  ],
  providers: [NavigationService,RegistrationService,AddressBookService,UserDetailsCommonService,
    { provide: HTTP_INTERCEPTORS, useClass: BasicAuthInterceptor, multi: true },
    { provide: ErrorHandler, useClass:GlobalErrorHandlerService}],
  bootstrap: [AppComponent]
})
export class AppModule { }
