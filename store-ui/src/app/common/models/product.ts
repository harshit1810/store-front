import { IBaseModel } from "./base";
import { Category } from "./category";
import { ProductVariant } from "./product-variant";

export class Product implements IBaseModel {
    id: number;
    version: number;
    key: string;
    createdAt: Date;
    createdBy: number;
    lastModifiedAt?: Date | undefined;
    lastModifiedBy?: number | undefined;
    name: string;
    description: string;
    slug: string;
    published: boolean;
    productType:any;
    keywords: string[];
    categories: ReadonlyArray<Category>;
    variants: ReadonlyArray<ProductVariant>;

    constructor(

    ) { }

}