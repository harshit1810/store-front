const isNonEmptyString = (s: any) => typeof s === 'string' && s.trim().length > 0;
const isNonEmptyArray = (a: any) => Array.isArray(a) && a.length > 0;
export {
    isNonEmptyString,
    isNonEmptyArray
};