import { Price } from "./price";
import { IProductVariantAttribute } from "./product-variant-attribute";

export class ProductVariant {
    sku: string;
    variantId: number;
    productId: string;
    images: ReadonlyArray<string>;
    isMaster: boolean;
    prices: ReadonlyArray<Price>;
    attributes: ReadonlyArray<IProductVariantAttribute>;

    constructor(
        sku: string,
        variantId: number,
        productId: string,
        isMaster?: boolean,
        images?: ReadonlyArray<string>,
        prices?: ReadonlyArray<Price>,
        attributes?: ReadonlyArray<IProductVariantAttribute>
    ) {
        Object.assign(this, {
            sku,
            variantId,
            productId,
            isMaster: isMaster === true,
            images: Array.isArray(images) ? images : [],
            prices: Array.isArray(prices) ? prices : [],
            attributes: Array.isArray(attributes) ? attributes : []
        });
    }
}