export interface IBaseModel {
    id: number;
    version: number;
    key: string;
    createdAt: Date;
    createdBy: number;
    lastModifiedAt?: Date;
    lastModifiedBy?: number;
}