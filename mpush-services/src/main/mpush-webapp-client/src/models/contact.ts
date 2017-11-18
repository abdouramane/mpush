export class Contact {
  private _id;
  private _firstName;
  private _email;
  private _category;
  private _login;


  get id() {
    return this._id;
  }

  set id(value) {
    this._id = value;
  }

  get login() {
    return this._login;
  }

  set login(value) {
    this._login = value;
  }

  get firstName() {
    return this._firstName;
  }

  set firstName(value) {
    this._firstName = value;
  }

  get email() {
    return this._email;
  }

  set email(value) {
    this._email = value;
  }

  get category() {
    return this._category;
  }

  set category(value) {
    this._category = value;
  }
}
