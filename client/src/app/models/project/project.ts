export class Project {
  title: string;
  createdOn: Date;
  _deadline: Date;

  constructor(title: string) {
    this.title = title;
    this.createdOn = new Date()
  }
}
