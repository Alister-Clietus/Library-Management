import { Component, OnInit } from '@angular/core';
import { Library } from '../models/library';
import { HttpservicesService } from 'src/app/service/httpservices.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-return',
  templateUrl: './return.component.html',
  styleUrls: ['./return.component.css']
})
export class ReturnComponent implements OnInit {
  dto: Library=new Library();
  
  constructor(private httpservice: HttpservicesService,private router: Router) 
  {
    
  }

  ngOnInit(): void 
  {

  }
  add()
  {
    this.httpservice.postdata("http://localhost:8011/borrow/returnbook",this.dto).subscribe((item:any)=>{
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
