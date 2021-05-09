import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';

import { CardModule } from 'primeng/card';

import { ProductDisplayCardComponent } from './product-display-card/product-display-card.component';
import { ProductListingComponent } from './product-listing/product-listing.component';
import { HttpService } from './services/http.service';
import { ProductSearchService } from './services/product-search.service';
import { CustomerService } from './services/customer.service';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';

@NgModule({
    declarations: [
        ProductDisplayCardComponent,
        ProductListingComponent,
        PageNotFoundComponent
    ],
    imports: [
        NgModule,
        CommonModule,
        CardModule,
        HttpClientModule
    ],
    providers: [
        HttpService,
        ProductSearchService,
        CustomerService
    ],
    exports: [
        CommonModule,
        CardModule,
        PageNotFoundComponent,
        ProductDisplayCardComponent,
        ProductListingComponent
    ]
})
export class AppModule { }
