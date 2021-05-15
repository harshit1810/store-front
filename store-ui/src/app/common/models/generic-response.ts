export interface IGenericResponse {
    code: number;
    status: string;
    errorCode: string;
    <T>(data: T): T;
}