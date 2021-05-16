const SearchController = require('./search'),
	SuggestController = require('./suggest');

module.exports = function(config) {
	return {
		searchController: SearchController(config),
		suggestController: SuggestController(config)
	};
};