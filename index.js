require('dotenv').config();
process.on('exit', code => {
	console.error('Exiting the process with code ' + code);
});
process.on('unhandledRejection', (error, promise) => {
	console.error('A promise rejection was unhandled', promise);
	console.error('Error: ', error );
});
process.on('uncaughtException', error  => {
	console.error('Fatal error ',  error);
});
const isProduction = process.env.NODE_ENV === 'production';

const logger = require('./plugins/logger')({
	isProduction 
});
require('./plugins/event-handler')();
const searchClient = require('./plugins/search-engine')({
	isProduction,
	logger
});

const Constants = require('./helpers/constants');
let serverModule = require('http');
const {
	searchController, suggestController 
} = require('./controllers')({
	isProduction,
	logger,
	searchClient
});

if (isProduction) {
	serverModule = require('https');
}

function requestListener(req, res) {
	res.setHeader('Access-Control-Allow-Origin', '*');
	res.setHeader('Access-Control-Allow-Methods', 'OPTIONS, GET');
	if (req.url.startsWith(Constants.SearchApiPath)) {
		searchController(req, res);
	} else if (req.url.startsWith(Constants.SuggestApiPath)) {
		suggestController(req, res);
	}
}

serverModule.createServer(requestListener).listen(parseInt(process.env.PORT), () => {
	logger.info('Server is running');
});