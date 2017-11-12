import {Contact} from "./contact";

export class User extends Contact {

  private _contacts : Contact[];

  get contacts(): Contact[] {
    return this._contacts;
  }

  set contacts(value: Contact[]) {
    this._contacts = value;
  }

}
