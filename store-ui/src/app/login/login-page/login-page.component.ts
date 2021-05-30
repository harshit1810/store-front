import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { IGenericResponse } from 'src/app/common/models/generic-response';
import { HttpService } from '../../common/services/http.service'
import { ILoginResponse } from 'src/app/common/models/login-response';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent implements OnInit {


  constructor(private http: HttpService) { }

  ngOnInit(): void {
    this.createLoginForm();
  }
  loginForm: FormGroup;
  createLoginForm() {
    this.loginForm = new FormGroup({
      username: new FormControl(''),
      password: new FormControl('')
    })
  }

  userLogin(data: any) {
    this.http.post('http://localhost:8080/api/customers/v1/login', data).subscribe(
      (res: IGenericResponse<ILoginResponse>) => {
        console.log(res.data.token);
      }
    )
  }

}
