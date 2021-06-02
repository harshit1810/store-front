export interface IGenericResponse<T> {
    code: number;
    status: string;
    errorCode: string;
    data: T;
}