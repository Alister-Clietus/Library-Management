import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BorrowComponent } from './borrow/borrow.component';
import { ReturnComponent } from './return/return.component';
import { LandingComponent } from './landing/landing.component';


const routes: Routes = 
[
  {
    path:"borrow",component:BorrowComponent
  },
  {
    path:"return",component:ReturnComponent
  },
  {
    path:"landing",component:LandingComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class LibraryRoutingModule { }
