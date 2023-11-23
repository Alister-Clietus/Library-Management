import { Component, OnInit } from '@angular/core';
import { HttpservicesService } from 'src/app/service/httpservices.service';
import { BookDTO } from '../model/book-dto';

@Component({
  selector: 'app-showbooklist',
  templateUrl: './showbooklist.component.html',
  styleUrls: ['./showbooklist.component.css']
})
export class ShowbooklistComponent implements OnInit {
  value: any;
  bookdto: BookDTO = new BookDTO();
  bookdata: any;

  constructor(private httpservice: HttpservicesService) 
  {

  }

  ngOnInit(): void 
  {
    this.value=this.httpservice.get("http://localhost:8009/books/getall").subscribe((item:any)=>{this.bookdata=item;console.log(this.bookdata.author)},
    error=>{console.log("Error")})
  }

}
