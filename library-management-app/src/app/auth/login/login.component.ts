import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Login } from 'src/app/book/model/book-dto';
import { HttpservicesService } from 'src/app/service/httpservices.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  userDTO: Login=new Login()
  constructor
  (
    private httpservice:HttpservicesService,
    private router: Router
  ) 
  { 

  }

  ngOnInit(): void 
  {

  }

  login()
  {
    let url="http://localhost:8010/auth/login"
    this.httpservice.postdata(url,this.userDTO).subscribe((item:any)=>{
      const token = item.token;
      if(token)
          {
            this.httpservice.setToken(token);
            this.router.navigate(['./book/landing']);
          }
          else
          {
            this.httpservice.ShowToasts('User', 'Create',item.username+" Login Unsucessful", 'Success');
          }
      },
      error=>{
        if(error.status == "400")
        {
        let msg = "";
        error.error.details.forEach(element => {
            msg = msg + element + "<br>"
        });
        this.httpservice.ShowToasts('User','',msg,'Danger');
    }
  })
  }

}
