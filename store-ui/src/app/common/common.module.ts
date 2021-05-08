import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CardModule } from 'primeng/card';

import { ProductDisplayCardComponent } from './product-display-card/product-display-card.component';
import { ProductListingComponent } from './product-listing/product-listing.component';

@NgModule({
    declarations: [
        ProductDisplayCardComponent,
        ProductListingComponent
    ],
    imports: [
        NgModule,
        CommonModule,
        CardModule
    ],
    providers: [],
    exports: [
        CommonModule,
        CardModule,
        ProductDisplayCardComponent,
        ProductListingComponent
    ]
})
export class AppModule { }
