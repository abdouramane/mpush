import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NouveauComponent } from './nouveau/nouveau.component';

@NgModule({
  imports: [
    CommonModule
  ],
  exports: [
    NouveauComponent
  ],
  declarations: [NouveauComponent]
})
export class MessageModule { }
