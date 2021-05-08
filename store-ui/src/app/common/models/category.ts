import { IBaseModel } from './base';
import { isNonEmptyArray, isNonEmptyString } from '../utils';
export class Category implements IBaseModel {
    id: number;
    version: number;
    key: string;
    createdAt: Date;
    createdBy: number;
    lastModifiedAt?: Date;
    lastModifiedBy?: number;
    name: string;
    description: string;
    level: number;
    published: boolean;
    parent: number;
    images: ReadonlyArray<string>;
    banners: ReadonlyArray<string>;

    constructor(
        id: number,
        version: number,
        key: string,
        createdAt: Date,
        createdBy: number,
        name: string,
        level: number,
        description: string,
        published?: boolean,
        parent?: number,
        images?: ReadonlyArray<string>,
        banners?: ReadonlyArray<string>,
        lastModifiedAt?: Date,
        lastModifiedBy?: number
    ) {
        Object.assign(this, {
            id,
            version,
            key,
            createdAt,
            createdBy,
            lastModifiedAt: lastModifiedAt instanceof Date ? lastModifiedAt : undefined,
            lastModifiedBy: Number.isInteger(lastModifiedBy) ? lastModifiedBy : undefined,
            name,
            level,
            description: isNonEmptyString(description) ? description.trim() : '',
            published: published === true,
            parent,
            images: isNonEmptyArray(images) ? images : [],
            banners: isNonEmptyArray(banners) ? banners : []
        });
    }

}