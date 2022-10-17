import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {HeaderComponent} from './components/header/header.component';
import {NoopAnimationsModule} from '@angular/platform-browser/animations';
import {MatIconModule} from "@angular/material/icon";
import {CalendarComponent} from './components/calendar/calendar.component';
import {ProjectsComponent} from './components/projects/projects.component';
import {MatButtonModule} from "@angular/material/button";
import {MatMenuModule} from "@angular/material/menu";
import {SettingsComponent} from './components/settings/settings.component';
import {AboutComponent} from './components/about/about.component';
import {RegisterComponent} from './components/register/register.component';
import {AlertComponent} from './components/alert/alert.component';
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {ErrorInterceptor} from "./helpers/error.interceptor";
import {JwtInterceptor} from "./helpers/jwt.interceptor";
import {ReactiveFormsModule} from '@angular/forms';
import {LoginComponent} from "./components/login/login.component";
import {FontAwesomeModule} from '@fortawesome/angular-fontawesome';
import {HomeComponent} from './components/home/home.component';
import {ColumnListComponent} from './components/projects/column-list/column-list.component';
import {ProjectOverviewComponent} from './components/projects/project-overview/project-overview.component';
import {MatListModule} from "@angular/material/list";
import {ScrollingModule} from "@angular/cdk/scrolling";
import { ProjectAddSheetComponent } from './components/projects/project-add-sheet/project-add-sheet.component';
import {MAT_BOTTOM_SHEET_DATA, MatBottomSheetModule} from "@angular/material/bottom-sheet";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatDatepickerModule} from "@angular/material/datepicker";
import {MatNativeDateModule} from "@angular/material/core";

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    CalendarComponent,
    ProjectsComponent,
    SettingsComponent,
    AboutComponent,
    LoginComponent,
    RegisterComponent,
    AlertComponent,
    HomeComponent,
    ColumnListComponent,
    ProjectOverviewComponent,
    ProjectAddSheetComponent
  ],
  imports: [
    BrowserModule,
    NoopAnimationsModule,
    ReactiveFormsModule,
    AppRoutingModule,
    MatMenuModule,
    MatButtonModule,
    MatIconModule,
    HttpClientModule,
    BrowserModule,
    FontAwesomeModule,
    MatListModule,
    ScrollingModule,
    MatBottomSheetModule,
    MatFormFieldModule,
    MatDatepickerModule,
    MatNativeDateModule
  ],
  providers: [
    {provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true},
    {provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true},
    { provide: MAT_BOTTOM_SHEET_DATA, useValue: {} }
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
