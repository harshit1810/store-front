import { Injectable } from '@angular/core';
import { environment } from '../../../environments/environment.local';
import { HttpService } from './http.service';

@Injectable()
export class CustomerService {
    private readonly apiUrl: string = environment.apiUrl.customer;
    private readonly Endpoint = {
        Login: '/login'
    };

    constructor(
        private service: HttpService
    ) {

    }

    login(username: string, password: string) {
        return this.service.post(this.apiUrl.concat(this.Endpoint.Login), {username, password});
    }
}