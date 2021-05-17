import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { LoginPageComponent } from './login-page/login-page.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { LoginRoutingModule } from './login-routing.module'
import { HttpService} from '../common/services/http.service'
@NgModule({
  declarations: [LoginPageComponent, SignUpComponent],
  imports: [
    CommonModule,
    LoginRoutingModule,FormsModule,
    ReactiveFormsModule
  ],
  providers: [HttpService],
  schemas: [ CUSTOM_ELEMENTS_SCHEMA ]
})
export class LoginModule { }
