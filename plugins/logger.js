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
	try {
		FS.rmSync(path);
	} catch(e) {
		if (e.code === 'ENOENT') {
			// log file did not exist
		} else {
			logger.error(JSON.stringify(e));
		}
	}

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
