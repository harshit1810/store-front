/* eslint-disable no-unused-vars */
const defaultLogger = {
		info: () => {},
		warn: () => {},
		error: () => {}
	}, defaultClient = {
		search: async () => {
			return {
				hits: []
			};
		},
		count: async () => {
			return 1;
		}
	};
module.exports = function(config) {
	const {
		isConnected = true,
		logger = defaultLogger,
		client = defaultClient
	} = config || {
	};
	const search = () => {};
	const count = () => {};
	return {
		search,
		count
	};
};