const elasticsearch = require('elasticsearch');

module.exports = function ({
	isProduction,
	logger,
	requestTimeout = 3000 
}) {
	const index = process.env.SEARCH_INDEX_NAME;
	const documentType = 'products';

	logger.debug('Connecting to elasticsearch...');

	const client = new elasticsearch.Client({
		host: process.env.BONSAI_URL,
		log: [{
			type: 'stdio',
			levels: isProduction
				? ['error', 'warning']
				: ['trace']
		}],
		apiVersion: '7.4'
	});

	client.ping({
		requestTimeout,
	}, error => {
		if (error) {
			client.isConnected = false;
			logger.error(
				'Failed to connect to elastic search ' 
				+ JSON.stringify(error)
			);
		} else {
			client.isConnected = true;
			client.index = index;
			client.documentType = documentType;
			logger.info('Success: Elasticsearch connection');
		}
	});

	return client;
};
