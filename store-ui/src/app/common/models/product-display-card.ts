import { Price } from './price';
export class ProductDisplayCard {
    slug: string;
    name: string;
    image: string;
    prices: ReadonlyArray<Price>;

    constructor(slug: string, name: string, image: string, prices: ReadonlyArray<Price>) {
        Object.assign(this, { slug, name, prices, image });        
    }
}