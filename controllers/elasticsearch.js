const searchPlugin = require('../plugins/search-engine');
module.exports = function () {
	const plugin = searchPlugin();
	const client = plugin.get();

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
		const {
			page = 1,
			size = 20,
			query: q
		} = data;
		try {
			const res = await client.search({
				index: plugin.index,
				// type: plugin.documentType,
				from: (page - 1) * size,
				size,
				q
			});
			return res && res.hits;
		} catch (e) {
			console.error('Failed to search for products: ' + JSON.stringify(e));
			throw e;
		}
	};

	/**
     * 
     * @param {Object} data 
     * @param {{[property: string]: any}} data.filters 
     */
	const count = async data => {
		try {
			const res = await client.count({
				index: plugin.index,
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
			console.error('Failed to get count: ' + JSON.stringify(error));
			throw error;
		}
	};

	return {
		search,
		count
	};
};