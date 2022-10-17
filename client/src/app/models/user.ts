export class User {
  username: string;
  displayName: string;
  token: string;

  constructor(username: string, displayName: string, token: string) {
    this.username = username;
    this.displayName = displayName;
    this.token = token;
  }
}


