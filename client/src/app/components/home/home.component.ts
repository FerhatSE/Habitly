import {Component, OnInit} from '@angular/core';
import {
  faBookOpenReader,
  faCalendar,
  faPenToSquare,
} from '@fortawesome/free-solid-svg-icons';
import {AuthenticationService} from "../../services/auth.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  displayName: String;
  faBookOpenReader = faBookOpenReader;
  faCalendar = faCalendar;
  faPenToSquare = faPenToSquare;

  constructor(
    private router: Router,
    private authenticationService: AuthenticationService,) {
  }

  ngOnInit(): void {
    this.authenticationService.currentUserSubject.subscribe(user => {
      if (user != null) {
        this.displayName = user.displayName;
      } else {
        // Send the user to the login page when not authenticated
        this.router.navigate(['/login']).then()
      }
    })
  }
}
