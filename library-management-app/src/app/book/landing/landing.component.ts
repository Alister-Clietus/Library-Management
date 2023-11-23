import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-landing',
  templateUrl: './landing.component.html',
  styleUrls: ['./landing.component.css']
})
export class LandingComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void 
  {

  }
  book()
  {
    this.router.navigate(['./library/landing']);
  }
  showbooks()
  {
    this.router.navigate(['./book/getall']);
  }
  showtable()
  {
    this.router.navigate(['./book/show']);
  }

}
