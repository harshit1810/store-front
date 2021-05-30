module.exports = function({
	isProduction
}) {
	return {
		warn: () => {},
		error: () => {},
		...(!isProduction
			? {
				debug: () => {},
				info: () => {}
			}
			: {
			})
	};
};