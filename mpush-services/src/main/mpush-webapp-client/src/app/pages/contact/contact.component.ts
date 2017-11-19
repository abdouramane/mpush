import {Component, OnInit, ViewChild} from '@angular/core';
import {UserService} from "../../../models/users.service";
import {MatPaginator} from "@angular/material";
import {MatTableDataSource} from "../../../models/table-data-source";
import {Contact} from "../../../models/contact";

@Component({
  selector: 'mp-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent implements OnInit {

  displayedColumns = ['id', 'lastName', 'firstName', 'phoneNumber', 'email', 'categories'];
  contacts: Contact[];
  dataSource: MatTableDataSource<Contact>;

  constructor(private userService: UserService) {
    this.userService.getCurrentUser().then(user => {
      this.contacts = user.contacts;
      this.dataSource = new MatTableDataSource(this.contacts);
    });
  }

  applyFilter(filterValue: string) {
    filterValue = filterValue.trim(); // Remove whitespace
    filterValue = filterValue.toLowerCase(); // MatTableDataSource defaults to lowercase matches
    this.dataSource.filter = filterValue;
  }

  @ViewChild(MatPaginator) paginator: MatPaginator;

  /**
   * Set the paginator after the view init since this component will
   * be able to query its view for the initialized paginator.
   */
  ngAfterViewInit() {
    if(this.dataSource){
      this.dataSource.paginator = this.paginator;
    }
  }


  ngOnInit() {

  }

}
