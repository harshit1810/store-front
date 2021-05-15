export interface IPaginationQuery {
    page?: number;
    size?: number;
    skip?: number;
    [key: string]: any
}