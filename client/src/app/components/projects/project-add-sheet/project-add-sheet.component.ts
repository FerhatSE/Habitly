import {Component, OnInit, ViewEncapsulation} from '@angular/core';
import {MatBottomSheetRef} from "@angular/material/bottom-sheet";
import {FormBuilder, FormGroup} from "@angular/forms";
import {Project} from "../../../models/project/project";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {environment} from "../../../../environments/environment";
import {ApiPaths} from "../../../models/api.paths";

@Component({
  selector: 'app-project-add-sheet',
  templateUrl: './project-add-sheet.component.html',
  styleUrls: ['./project-add-sheet.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class ProjectAddSheetComponent implements OnInit {
  addProjectForm: FormGroup;
  selected: Date | null;

  constructor(private http: HttpClient,
              private _bottomSheetRef: MatBottomSheetRef<ProjectAddSheetComponent>,
              private _formBuilder: FormBuilder,
  ) {
    this.addProjectForm = this._formBuilder.group({
      title: [''],
    })
  }

  ngOnInit(): void {
  }

  onAddProjectSubmit() {
    this._bottomSheetRef.dismiss() // Close bottom sheet

    const title = this.f()['title'].value;
    const project = new Project(title)

    let options = {
      headers: new HttpHeaders().set('Content-Type', 'application/json')
    };

    this.http.post(`${environment.baseURL}/${ApiPaths.Project}/add`, project, options).pipe().subscribe(data => {
      console.log(data)
    })
  }

  // convenience getter for easy access to form fields
  f() {
    return this.addProjectForm.controls;
  }
}
