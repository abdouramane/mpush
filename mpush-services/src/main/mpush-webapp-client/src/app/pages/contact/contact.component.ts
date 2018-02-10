import {Component, OnInit, ViewChild} from '@angular/core';
import {UserService} from "../../core/user/user.service";
import {MatPaginator, MatSort} from "@angular/material";
import {MatTableDataSource} from "../../shared/table-data-source";
import {Contact} from "../../core/models/contact.model";
import {SelectionModel} from "@angular/cdk/collections";
import {FormControl} from "@angular/forms";
import {Category} from "../../core/models/category.model";
import {User} from "../../core/models/user.model";

@Component({
  selector: 'mp-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent implements OnInit {

  displayedColumns = ['select', 'id', 'lastName', 'firstName', 'phoneNumber', 'email', 'categories'];
  contacts: Contact[];
  newContact: Contact = new Contact();
  currentUser: User;
  selectedContact: Contact = new Contact();
  dataSource: MatTableDataSource<Contact>;
  initialSelection = [];
  allowMultiSelect = true;
  categoryFormControl = new FormControl();
  selection : SelectionModel<Contact> = new SelectionModel<Contact>(this.allowMultiSelect, this.initialSelection);
  avalaibleCategories : Array<Category> = [];

  constructor(private userService: UserService) {

  }

  applyFilter(filterValue: string) {
    filterValue = filterValue.trim(); // Remove whitespace
    filterValue = filterValue.toLowerCase(); // MatTableDataSource defaults to lowercase matches
    this.dataSource.filter = filterValue;
  }

  /* TODO implement category selection filter */
  applyFilterCategorySelection(categoryId) {
    this.dataSource.filter = categoryId;
  }

  @ViewChild(MatPaginator) paginator: MatPaginator;

  @ViewChild(MatSort) sort: MatSort;

  /**
   * Set the paginator after the view init since this component will
   * be able to query its view for the initialized paginator.
   */
  ngAfterViewInit() {
    if(this.dataSource){
      this.dataSource.paginator = this.paginator;
      this.dataSource.sort = this.sort;
    }
  }

  /** Whether the number of selected elements matches the total number of rows. */
  isAllSelected() {
    const numSelected = this.selection.selected.length;
    const numRows = this.dataSource.data.length;
    return numSelected == numRows;
  }

  /** Selects all rows if they are not all selected; otherwise clear selection. */
  masterToggle() {
    this.isAllSelected() ?
      this.selection.clear() :
      this.dataSource.data.forEach(row => this.selection.select(row));
  }

  /* Check if an item is in the available categorie */
  isInAvailableCategories(item : Category) {
    for(let i=0;i<this.avalaibleCategories.length;i++){
      if(this.avalaibleCategories[i].id === item.id){
        return true;
      }
    }

    return false;
  }

  /* Delete selected contacts */
  deleteSelection() {
    //TODO supprimer contacts
  }

  ngOnInit() {
    this.userService.getCurrentUser().then(user => {
      this.currentUser = user;
      this.contacts = user.contacts;
      this.dataSource = new MatTableDataSource(this.contacts);
      this.ngAfterViewInit();

      //Get user's contacts categories
      let result = this.contacts.map(function (item) {
        return item.categories;
      }).filter(function (item) {
        return item.length > 0;
      });

      //Filter categories and keep only one unique value for each existing one in the var list avalaibleCategories
      result.forEach(function (value) {// Loop over categories
        value.forEach(function (subValue) {// Loop over categorie values
          if(!this.isInAvailableCategories(subValue)) {// Put value in the available one if it doesn't exist yet
            this.avalaibleCategories.push(subValue);
          }
        }, this);
      }, this); //Propagate the application context (this) in order to have access to the var isinAvailableCategories
    });
  }

  initNewContact() {
    this.newContact = new Contact();
  }

  addContact() {
    console.log(this.newContact);

    if(!this.currentUser.contacts) {
      this.currentUser.contacts = [];
    }
    this.userService.newContact(this.currentUser.id, this.newContact).then(
      user => this.currentUser = user
    );
  }
}
