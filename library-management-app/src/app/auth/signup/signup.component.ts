import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/book/model/book-dto';
import { HttpservicesService } from 'src/app/service/httpservices.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  userDTO: User=new User()


  constructor(private httpservice:HttpservicesService, private router: Router ) { }

  ngOnInit(): void 
  {

  }

  Signup()
  {
    let url="http://localhost:8010/auth/signup"
    this.httpservice.postdata(url,this.userDTO).subscribe((item:any)=>{
      this.httpservice.ShowToasts('User', 'Create',item.body, 'Success');
      this.router.navigate(['./auth/login']);
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
