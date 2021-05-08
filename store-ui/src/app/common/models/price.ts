export class Price {
    amount: number;
    validFrom: Date;
    validTo: Date;

    constructor(amount: number, from?: Date, to?: Date) {
        this.amount = amount;
        (from instanceof Date ? this.validFrom = from : void 0);
        (to instanceof Date ? this.validTo = to : void 0);
    }
}