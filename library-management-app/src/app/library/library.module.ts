import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { LibraryRoutingModule } from './library-routing.module';
import { BorrowComponent } from './borrow/borrow.component';
import { ReturnComponent } from './return/return.component';
import { FormsModule } from '@angular/forms';
import { LandingComponent } from './landing/landing.component';


@NgModule({
  declarations: [BorrowComponent, ReturnComponent, LandingComponent],
  imports: [
    CommonModule,
    LibraryRoutingModule,
    FormsModule
  ]
})
export class LibraryModule { }
