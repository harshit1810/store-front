process.on('exit', () => {
	console.info('Exiting the process');
});
process.on('unhandledRejection', (error, promise) => {
	console.log('A promise rejection was unhandled', promise);
	console.log('Error: ', error );
});
process.on('uncaughtException', error  => {
	console.error('Fatal error ',  error);
});
const isProduction = process.env.NODE_ENV === 'production';
const searchPlugin = require('./plugins/search-engine');
require('./plugins/event-handler')();
const Constants = require('./helpers/constants');
let serverModule = require('http');
const {
	searchController, suggestController 
} = require('./controllers')({
	isProduction
});

if (isProduction) {
	serverModule = require('https');
}

function requestListener(req, res) {
	if (req.url.startsWith(Constants.SearchApiPath)) {
		searchController(req, res);
	} else if (req.url.startsWith(Constants.SuggestApiPath)) {
		suggestController(req, res);
	}
}

serverModule.createServer(requestListener).listen(parseInt(process.env.PORT), () => {
	console.info('Server is running');
	searchPlugin().get();
});