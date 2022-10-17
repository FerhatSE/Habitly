import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {AuthenticationService} from "../../services/auth.service";
import {faQuestion, faCog, faDoorOpen, faDoorClosed, faEllipsisVertical} from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css'],
})
export class HeaderComponent implements OnInit {
  showNavigation: boolean;
  authenticated: boolean;
  currentRoute: string;
  faQuestion = faQuestion;
  faCog = faCog;
  faDoorOpen = faDoorOpen;
  faDoorClosed = faDoorClosed;
  faEllipsisVertical = faEllipsisVertical;

  constructor(private router: Router, private authenticationService: AuthenticationService) {
  }

  ngOnInit(): void {
    this.router.events.subscribe(() => {
      const url = this.router.url;

      /* Check if the user navigated to one of these routes.
         Hide the navigation links if this is the case.
       */
      this.showNavigation = url != "/home" && url != "/login" && url != "/register";

      this.authenticationService.currentUserSubject.subscribe(value => {
        this.authenticated = value == null;
      })
    })
  }

  logout(): void {
    this.authenticationService.logout();

    // Return the user to the homepage after logging out
    this.router.navigate(['/home']).then()
  }
}
