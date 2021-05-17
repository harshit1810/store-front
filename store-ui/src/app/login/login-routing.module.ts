import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginPageComponent } from './login-page/login-page.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { HttpService } from '../common/services/http.service';
const routes: Routes = [
    { path: 'loginpage', component: LoginPageComponent },
    { path: 'signup', component: SignUpComponent}
];
@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule],
    providers: [HttpService],
})

export class LoginRoutingModule{ }