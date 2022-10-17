import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {CalendarComponent} from "./components/calendar/calendar.component";
import {ProjectsComponent} from "./components/projects/projects.component";
import {NotesComponent} from "./components/notes/notes.component";
import {RegisterComponent} from "./components/register/register.component";
import {LoginComponent} from "./components/login/login.component";
import {SettingsComponent} from "./components/settings/settings.component";
import {AboutComponent} from "./components/about/about.component";
import {HomeComponent} from "./components/home/home.component";

const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  {path: 'projects', component: ProjectsComponent},
  {path: 'calendar', component: CalendarComponent},
  {path: 'notes', component: NotesComponent},
  {path: 'about', component: AboutComponent},
  {path: 'settings', component: SettingsComponent},
  {path: 'login', component: LoginComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'home', component: HomeComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
