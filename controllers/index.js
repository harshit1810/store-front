const SearchController = require('./search'),
	SuggestController = require('./suggest'),
	ElasticsearchService = require('../service/elasticsearch');

/**
 * 
 * @param {Object} config 
 * @param {boolean} config.isProduction
 * @param {{}} config.logger 
 * @param {{}} config.searchClient 
 * @returns 
 */
module.exports = function(config) {
	const {
		searchClient: client, ...partialConfig 
	} = config;
	partialConfig.searchService = ElasticsearchService({
		client,
		logger: config.logger
	});
	return {
		searchController: SearchController(partialConfig),
		suggestController: SuggestController(partialConfig)
	};
};