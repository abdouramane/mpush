import {Contact} from "./contact.model";

export class User extends Contact {

  private _login;

  private _contacts : Contact[];

  get contacts(): Contact[] {
    return this._contacts;
  }

  set contacts(value: Contact[]) {
    this._contacts = value;
  }

  get login() {
    return this._login;
  }

  set login(value) {
    this._login = value;
  }
}
