import { IBaseModel } from "./base";
import { AttributeDefinition } from './attribute-definition';
import { isNonEmptyArray } from "../utils";

export class ProductType implements IBaseModel {
    id: number;
    version: number;
    key: string;
    createdAt: Date;
    createdBy: number;
    lastModifiedAt?: Date | undefined;
    lastModifiedBy?: number | undefined;

    name: string;
    attributeDefinitions: ReadonlyArray<AttributeDefinition>;

    constructor(
        id: number,
        version: number,
        key: string,
        createdAt: Date,
        createdBy: number,
        name: string,
        attributeDefinitions?: ReadonlyArray<AttributeDefinition>,
        lastModifiedAt?: Date,
        lastModifiedBy?: number
    ) {
        Object.assign(this, {
            id,
            version,
            key,
            createdAt,
            createdBy,
            name,
            lastModifiedAt: lastModifiedAt instanceof Date
                ? lastModifiedAt
                : undefined,
            lastModifiedBy: Number.isInteger(lastModifiedBy)
                ? lastModifiedBy
                : undefined,
            attributeDefinitions: isNonEmptyArray(attributeDefinitions)
                ? attributeDefinitions
                : []
        });
    }
}