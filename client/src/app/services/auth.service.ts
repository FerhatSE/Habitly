import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {BehaviorSubject, map} from 'rxjs';
import {User} from '../models/user';
import {environment} from "../../environments/environment";
import {ApiPaths} from "../models/api.paths";

const TOKEN_KEY = 'auth-token';
const USER_KEY = 'auth-user';

@Injectable({providedIn: 'root'})
export class AuthenticationService {
  currentUserSubject: BehaviorSubject<User>;

  constructor(private http: HttpClient) {
    this.currentUserSubject = new BehaviorSubject<User>(
      this.getUser());
  }

  public get getToken(): string | null {
    return window.sessionStorage.getItem(TOKEN_KEY);
  }

  public getUser(): any {
    const user = window.sessionStorage.getItem(USER_KEY);
    if (user) {
      return JSON.parse(user);
    }
    return null;
  }

  public get currentUserValue(): User {
    return this.currentUserSubject.value;
  }

  login(username: String, password: String) {
    let options = {
      headers: new HttpHeaders().set('Content-Type', 'application/json')
    };

    return this.http.post<any>(`${environment.baseURL}/${ApiPaths.Auth}/login`,
      {username, password}, options).pipe(map(data => {
      const user = new User(data["username"], data["displayName"], data["jwtToken"])

      // store user details and JWT token in session storage to keep user logged in between page refreshes
      window.sessionStorage.removeItem(TOKEN_KEY);
      window.sessionStorage.setItem(TOKEN_KEY, user.token);
      this.currentUserSubject.next(user);

      return user;
    }))
  }

  register(username: String, displayName: String, password: String) {
    let options = {
      headers: new HttpHeaders().set('Content-Type', 'application/json')
    };

    return this.http.post<any>(`${environment.baseURL}/${ApiPaths.Auth}/register`,
      {username, displayName, password}, options).pipe()
  }

  logout() {
    window.sessionStorage.clear(); // remove user from session storage and set current user to null
    window.location.reload() // Reload the current page to redirect to login page
    this.currentUserSubject.next(null!); // Clear the user subject to reflect the logout action
  }
}
