import { Component, OnInit } from '@angular/core';
import { BookDTO } from '../model/book-dto';
import { HttpservicesService } from 'src/app/service/httpservices.service';


@Component({
  selector: 'app-addbooks',
  templateUrl: './addbooks.component.html',
  styleUrls: ['./addbooks.component.css']
})
export class AddbooksComponent implements OnInit 
{

  bookdto: BookDTO=new BookDTO()
  response: unknown;


  constructor
  (
    private httpservice: HttpservicesService
  ) 
  {

  } //constructor ends here

  ngOnInit(): void 
  {

  } //ngonit ends here

  add()
  {
    this.httpservice.postdata("http://localhost:8009/books/add",this.bookdto).subscribe((item: any)=>
    {this.httpservice.ShowToasts('User', 'Create',item.message, 'Success');},
    error=>{if(error.status == "400"){
      let msg = "";
      error.error.details.forEach(element => {
          msg = msg + element + "<br>"
      });
      this.httpservice.ShowToasts('User','',msg,'Danger');
  }})
  } //add ends here


  
}
