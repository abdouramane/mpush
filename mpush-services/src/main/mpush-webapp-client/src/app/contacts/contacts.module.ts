import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ContactComponent } from './contact/contact.component';
import {
  MatCheckboxModule, MatFormFieldModule, MatInputModule, MatPaginatorModule, MatSelectModule, MatSortModule,
  MatTableModule
} from "@angular/material";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    MatTableModule,
    MatFormFieldModule,
    MatPaginatorModule,
    MatFormFieldModule,
    MatInputModule,
    MatSortModule,
    MatCheckboxModule,
    MatSelectModule
  ],
  exports: [ContactComponent],
  declarations: [ContactComponent]
})
export class ContactsModule { }
