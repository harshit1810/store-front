const {
	isNonEmptyString 
} = require('../helpers/util');
/**
 * 
 * @param {Object} config 
 * @param {{}} config.client 
 * @param {{}} config.logger 
 * @returns 
 */
module.exports = function (config) {

	const isClientConnected = () => {
		if (config.client.isConnected) {
			return;
		}
		throw new Error('Not connected to search engine');
	};


	/**
     * 
     * @param {Object} data 
     * @param {string} data.query
     * @param {number?} data.page
     * @param {number?} data.size the page size
     * @returns {Promise<{total:{}, hits: Array.<{}>}>}
     * @throws if search fails
     */
	const search = async data => {
		isClientConnected();
		const {
			page = 1,
			size = 20,
			query: q
		} = data;
		try {
			const res = await config.client.search({
				index: config.client.index,
				type: config.client.documentType,
				from: (page - 1) * size,
				size,
				...(isNonEmptyString(q)
					? {
						q 
					}
					: {
					})
			});
			return res && res.hits;
		} catch (e) {
			config.logger.error('Failed to search for products: ' + JSON.stringify(e));
			throw e;
		}
	};

	/**
     * 
     * @param {Object} data 
     * @param {{[property: string]: any}} data.filters 
     */
	const count = async data => {
		isClientConnected();
		try {
			const res = await config.client.count({
				index: config.client.index,
				...(Object.keys(data.filters).length > 0
					? {
						body: {
							query: {
								filtered: {
									filter: {
										terms: {
											...data.filters
										}
									}
								}
							}
						}
					}
					: {
					})
			});
			return res && res.count;
		} catch(error) {
			config.logger.error('Failed to get count: ' + JSON.stringify(error));
			throw error;
		}
	};

	return {
		search,
		count
	};
};