import {Injectable} from "@angular/core";
import {Http} from "@angular/http";
import {User} from "../core/models/user.model";
import {Message} from "../core/models/message.model";

@Injectable()
export class MessageService {

  private messageUrl = '/mpush/api/messages';

  constructor(private http: Http, public currentUser: User) {

  }

  sendMessage(message: Message) {
    return this.http.post(this.messageUrl, message)
      .toPromise()
      .then(response => response.json() as User)
      .catch(MessageService.handleError);
  }

  private static handleError(error: any): Promise<any> {
    console.error('An error occurred', error);
    return Promise.reject(error.message || error);
  }

}
