import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { IGenericResponse } from '../models/generic-response';
import { Observable, throwError } from 'rxjs';

@Injectable()
export class HttpService {
    constructor(private http: HttpClient) {

    }

    get(url: string, headers?: HttpHeaders) {
        return this.http.get<IGenericResponse<any>>(url, {
            headers
        });
    }

    post(url: string, data: {[key: string]: any} = {}, headers?: {[key: string]: any}) {
        return this.http.post<IGenericResponse<any>>(url, data, {
            headers: new HttpHeaders({
                ...headers,
                'Content-Type': 'application/json'
            })
        });
    }
}

