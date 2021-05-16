const ApiBasePath = '/api/product-search/' + process.env.API_VERSION + '/';

const SearchApiName = 'search';
const SearchApiPath = ApiBasePath + SearchApiName;

const SuggestApiName = 'suggest';
const SuggestApiPath = ApiBasePath + SuggestApiName;

module.exports = {
	ApiBasePath,
	SearchApiName,
	SearchApiPath,
	SuggestApiName,
	SuggestApiPath
};
