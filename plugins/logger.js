const BUNYAN = require('bunyan');
const PATH = require('path');
const FS = require('fs');

module.exports = function({
	isProduction 
}) {
	isProduction = false;

	const logFileName = (isProduction
		? 'prod'
		: 'dev') + '.log';
	const path = PATH.join(__dirname, '..', 'logs', logFileName);

	// remove existing log file
	FS.rmSync(path);

	const logger = BUNYAN.createLogger({
		name: 'search-service',
		streams: [
			...(isProduction
				? [
					{
						level: BUNYAN.WARN,
						path
					},
					{
						level: BUNYAN.ERROR,
						path
					}
				]
				: [{
					level: BUNYAN.DEBUG,
					path
				}]
			)
		],
		...(!isProduction
			? {
				src: true 
			}
			: {
			})
	});

	return logger;
};
