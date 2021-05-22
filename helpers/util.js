const isNonEmptyArray = arr => {
	return Array.isArray(arr) && arr.length > 0;
};

const isNonEmptyString = str => {
	return typeof str === 'string' && str.trim().length > 0;
};

module.exports = {
	isNonEmptyArray,
	isNonEmptyString
};