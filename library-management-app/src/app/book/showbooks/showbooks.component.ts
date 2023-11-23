import { Component, OnInit } from '@angular/core';
import { BookDTO } from '../model/book-dto';


declare var $: any;
declare var jQuery: any;
@Component({
  selector: 'app-showbooks',
  templateUrl: './showbooks.component.html',
  styleUrls: ['./showbooks.component.css']
})
export class ShowbooksComponent implements OnInit 
{
  static obj: ShowbooksComponent;
  bookdto: BookDTO = new BookDTO();
  userDatatable: any;

  constructor() 
  {

  }

  ngOnInit()
  {
    ShowbooksComponent.obj=this
    this.getUsers();
  }

  getSearchInputs() 
  {
    console.log("entered get user search")
    let bookdto: BookDTO = new BookDTO();
    bookdto.title = $('#idtitle').val();
    console.log(bookdto.title)
    bookdto.author = $('#idauthor').val();
    console.log(bookdto.author)
    bookdto.isbn = $('#idisbn').val();
    console.log(bookdto.isbn)
    bookdto.numberOfPages = $('#idUserName').val();
    console.log(bookdto.numberOfPages)
    if (bookdto.title == null || bookdto.title == undefined) {
      bookdto.title = '';
    }
    if (bookdto.author == null || bookdto.author == undefined) {
      bookdto.author = '';
    }
    if (bookdto.isbn == null || bookdto.isbn == undefined) {
      bookdto.isbn = '';
    }
    if (bookdto.numberOfPages == null || bookdto.numberOfPages == undefined) {
      bookdto.numberOfPages = 0;
    }
    if (Object.keys(bookdto).length > 0) {
      return JSON.stringify(bookdto);
    }
    return "";
  }  //search input function ends here




  getUsers() 
  {
    console.log("in to getusers")
    this.userDatatable = $('#myTable').DataTable({
      "bProcessing": true,
      "bDeferRender": true,
      "ordering": false,
      bAutoWidth: false,
      bServerSide: true,
      sAjaxSource: "http://localhost:8009/books/search",
      dataSrc: 'aaData',
      sServerMethod: 'GET',
      "fnServerParams": function (aoData) {
        var dataString =ShowbooksComponent.obj.getSearchInputs();
        aoData.push({ name: "searchParam", value: dataString });
      },
      "fnServerData": (sSource, aoData, fnCallback, oSettings) => {
        oSettings.jqXHR = $.ajax({
          "dataType": 'json',
          "type": "GET",
          "url": sSource,
          "data": aoData,
          "beforeSend": (xhr) => {
          },
          "success": (data) => {
            // this.commonServiceProvider.setStatusCount(this.statusCountList, data.countByStatus);
            fnCallback(data);
          },
          // "success": fnCallback,
          "error": (e) => {
            console.log("lkfeo", e);
            if (e.status == "403" || e.status == "401") {
              // this.commonServiceProvider.GoToErrorHandling(e);
            }
          }
        });
      },
      "bSort": false,
      "sDom": "<rt><'row border-top pt-2'<'col-sm-12 col-md-5'l><'col-sm-12 col-md-7'p>>",
      "aoColumns": [
        { "mDataProp": "Author", "bSortable": false },
        { "mDataProp": "Title", "bSortable": false },
        { "mDataProp": "isbn", "bSortable": false, },
        { "mDataProp": "Number", "bSortable": false },
        
        {
          "mDataProp": "status", "bSortable": false,
          "mRender": function (data) {
            if (data === 'BOOKED') {
              return '<span class="badge badge-primary ipsh-badge-pending">BOOK IS BOOKED</span>';
            } else if (data === 'INSTOCK') {
              return '<span class="badge badge-primary ipsh-badge-pending">BOOK IS IN STOCK</span>';
            } else if (data === 'APPROVED') {
              return '<span class="badge badge-primary ipsh-badge-approve">Approved</span>';
            } else if (data === 'REJECTED') {
              return '<span class="badge badge-primary ipsh-badge-reject">Rejected</span>';
            } else if (data === 'DELETED') {
              return '<span class="badge badge-primary ipsh-badge-reject">Deleted</span>';
            } else if (data === 'PROCESSED') {
              return '<span class="badge badge-primary ipsh-badge-approve">Processed</span>';
            }
            return data;
          }
        }
      ]
    });
  }

  searchBooks()
  {
    this.userDatatable.draw();
  }
}
