import {TaskLabel} from "./task-label";

export class Task {
  title: string;
  description: string;
  createdOn: Date;
  _deadline: Date;
  _label: TaskLabel;

  constructor(title: string, description: string) {
    this.title = title;
    this.description = description;
    this.createdOn = new Date()
  }
}
