import {Contact} from "../../pages/contact/contact.model";

export class User extends Contact {

  private _contacts : Contact[];

  get contacts(): Contact[] {
    return this._contacts;
  }

  set contacts(value: Contact[]) {
    this._contacts = value;
  }

}
