import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { BookRoutingModule } from './book-routing.module';
import { ShowbooksComponent } from './showbooks/showbooks.component';
import { AddbooksComponent } from './addbooks/addbooks.component';
import { ShowbooklistComponent } from './showbooklist/showbooklist.component';
import { FormsModule } from '@angular/forms';
import { LandingComponent } from './landing/landing.component';


@NgModule({
  declarations: [ShowbooksComponent, AddbooksComponent, ShowbooklistComponent, LandingComponent],
  imports: [
    CommonModule,
    BookRoutingModule,
    FormsModule
    // ToastrModule
  ]
})
export class BookModule { }
