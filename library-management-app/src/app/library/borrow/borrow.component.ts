import { Component, OnInit } from '@angular/core';
import { Library } from '../models/library';
import { HttpservicesService } from 'src/app/service/httpservices.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-borrow',
  templateUrl: './borrow.component.html',
  styleUrls: ['./borrow.component.css']
})
export class BorrowComponent implements OnInit {
  dto: Library=new Library();
  constructor(private httpservice: HttpservicesService,private router: Router) { }

  ngOnInit(): void 
  {

  }
  add()
  {
    console.log(this.dto)
    this.httpservice.postdata("http://localhost:8011/borrow/getbook",this.dto).subscribe((item:any)=>{
      this.httpservice.ShowToasts('User', 'Create',item.message, 'Success');},
    error=>{if(error.status == "400"){
      let msg = "";
      error.error.details.forEach(element => {
          msg = msg + element + "<br>"
      });
      this.httpservice.ShowToasts('User','',msg,'Danger');
  }})
  }
  back()
  {
    this.router.navigate(['./library/landing']);
  }
  clear()
  {

  }

}
