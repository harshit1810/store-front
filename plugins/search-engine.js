const elasticsearch = require('elasticsearch');

let client;

function createClient() {
	client = new elasticsearch.Client({
		host: process.env.BONSAI_URL,
		log: [{
			type: 'stdio',
			levels: ['error', 'warning']
		}],
		apiVersion: '7.4'
	});

	client.ping({
		requestTimeout: 30000,
	}, console.error.bind(console));
}

module.exports = function () {
	const index = process.env.SEARCH_INDEX_NAME;
	const documentType = 'products';
	return {
		index,
		documentType,
		get: () => {
			if (typeof client === 'undefined') {
				createClient();
			}
			return client;
		}
	};
};
