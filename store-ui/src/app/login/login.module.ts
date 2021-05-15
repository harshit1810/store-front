import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { LoginPageComponent } from './login-page/login-page.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { LoginRoutingModule } from './login-routing.module'

@NgModule({
  declarations: [LoginPageComponent, SignUpComponent],
  imports: [
    CommonModule,
    LoginRoutingModule
  ],
  schemas: [ CUSTOM_ELEMENTS_SCHEMA ]
})
export class LoginModule { }
