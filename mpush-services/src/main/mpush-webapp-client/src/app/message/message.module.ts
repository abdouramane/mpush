import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NouveauComponent } from './nouveau/nouveau.component';
import {MatAutocompleteModule, MatFormFieldModule, MatInputModule} from "@angular/material";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";

@NgModule({
  imports: [
    FormsModule,
    CommonModule,
    MatFormFieldModule,
    ReactiveFormsModule,
    MatAutocompleteModule,
    MatInputModule
  ],
  exports: [
    NouveauComponent
  ],
  declarations: [NouveauComponent]
})
export class MessageModule { }
