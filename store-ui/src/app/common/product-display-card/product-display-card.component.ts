import { Component, Input, Output, EventEmitter } from '@angular/core';
import { ProductDisplayCard } from '../models/product-display-card';

@Component({
    selector: 'app-product-display-card',
    styleUrls: ['./product-display-card.component.css'],
    templateUrl: './product-display-card.component.html'
})
export class ProductDisplayCardComponent {
    @Input() product: ProductDisplayCard;
    @Output() clicked = new EventEmitter<string>();

    clickHandler() {
        this.clicked.emit(this.product.name);
    }
}