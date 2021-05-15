import { Injectable } from '@angular/core';
import { environment } from '../../../environments/environment.local';
import { IPaginationQuery } from '../models/pagination-query';
import { HttpService } from './http.service';

@Injectable()
export class ProductSearchService {
    private readonly apiUrl: string = environment.apiUrl.productSearch;
    constructor(
        private service: HttpService
    ) {

    }

    search(query: IPaginationQuery) {
        const url = this.apiUrl;
        return this.service.get(url);
    }
}