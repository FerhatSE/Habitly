import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';

import {User} from '../models/user';
import {environment} from "../../environments/environment";
import {ApiPaths} from "../models/api.paths";

@Injectable({providedIn: 'root'})
export class UserService {

  private readonly baseURL: string

  constructor(private http: HttpClient) {
    this.baseURL = environment.baseURL + ApiPaths.Auth
  }

  getAll() {
    return this.http.get<User[]>(this.baseURL);
  }

  register(user: User) {
    return this.http.post(this.baseURL, user);
  }

  delete(id: number) {
    return this.http.delete(`${this.baseURL}/${id}`);
  }
}
