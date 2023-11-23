import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ShowbooksComponent } from './showbooks/showbooks.component';
import { AddbooksComponent } from './addbooks/addbooks.component';
import { ShowbooklistComponent } from './showbooklist/showbooklist.component';
import { LandingComponent } from './landing/landing.component';


const routes: Routes = 
[
  {
    path:"show",component:ShowbooksComponent 
  },
  {
    path:"add",component:AddbooksComponent 
  },
  {
    path:"getall",component:ShowbooklistComponent 
  },
  {
    path:"landing",component:LandingComponent 
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class BookRoutingModule { }
