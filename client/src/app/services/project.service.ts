import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';

import {User} from '../models/user';
import {environment} from "../../environments/environment";
import {ApiPaths} from "../models/api.paths";
import {Project} from "../models/project/project";

@Injectable({providedIn: 'root'})
export class ProjectService {

  private readonly baseURL: string

  constructor(private http: HttpClient) {
    this.baseURL = environment.baseURL + ApiPaths.Project
  }

  loadProjects() {
    return this.http.get<Project[]>(`${environment.baseURL}/${ApiPaths.Project}`).pipe()
  }

  register(user: User) {
    return this.http.post(this.baseURL, user);
  }

  delete(id: number) {
    return this.http.delete(`${this.baseURL}/${id}`);
  }
}
