import {Component, OnInit} from '@angular/core';
import {Project} from "../../../models/project/project";

@Component({
  selector: 'app-column-list',
  templateUrl: './column-list.component.html',
  styleUrls: ['./column-list.component.css']
})
export class ColumnListComponent implements OnInit {

  constructor(private project: Project) {
  }

  ngOnInit(): void {
  }
}
