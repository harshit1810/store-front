/**
 * 
 * @param {{}} searchResult the search results obtained from search engine.
 * @returns 
 */
const convertActualResponseToLogicalResponse = searchResult => {
	const output = {
		pagination: {
		},
		facets: {
		},
		results: []
	};
	if (!searchResult) {
		return output;
	}
	output.results = (Array.isArray(searchResult.hits)
		? searchResult.hits
		: []).map(document => {
		return {
			score: document._score,
			id: document._id,
			...(document._source || {
			})
		};
	});
	return output;
};

module.exports = {
	convertActualResponseToLogicalResponse
};