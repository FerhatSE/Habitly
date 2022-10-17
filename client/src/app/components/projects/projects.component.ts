import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {ApiPaths} from "../../models/api.paths";
import {environment} from "../../../environments/environment";
import {Project} from "../../models/project/project";
import {ProjectService} from "../../services/project.service";
import {MatBottomSheet} from "@angular/material/bottom-sheet";
import {ProjectAddSheetComponent} from "./project-add-sheet/project-add-sheet.component";

@Component({
  selector: 'app-projects',
  templateUrl: './projects.component.html',
  styleUrls: ['./projects.component.css']
})
export class ProjectsComponent implements OnInit {
  addProjectForm: FormGroup;
  projects: Project[];

  constructor(private http: HttpClient,
              private formBuilder: FormBuilder,
              private projectService: ProjectService,
              private _bottomSheet: MatBottomSheet
  ) {
    this.projects = Array.from([new Project("test1"),
      new Project("test2"),
      new Project("test3"),
      new Project("test4"),
      new Project("test3"),
      new Project("test2"),
      new Project("test2"),
      new Project("test3"),
      new Project("test4"),
      new Project("test2"),
      new Project("test3"),
      new Project("test4")]);
  }

  ngOnInit(): void {
    //TODO remove debugging code
    this.addProjectForm = this.formBuilder.group({
      title: [''],
      description: ['']
    })
    // Fetch the projects for the authenticated user
    // this.projectService.loadProjects()
    //   .subscribe((projects: Project[]) => {
    //     this.projects = projects
    //   })
  }

  openBottomSheet(): void {
    this._bottomSheet.open(ProjectAddSheetComponent);
  }
}
