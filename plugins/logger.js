const bunyan = require('bunyan');
const path = require('path');

module.exports = function({
	isProduction 
}) {
	const logFileName = (isProduction
		? 'prod'
		: 'dev') + '.log';

	const logger = bunyan.createLogger({
		name: 'search-service',
		streams: [
			...(isProduction
				? [
					{
						level: bunyan.WARN,
						path: path.join(__dirname, '..', 'logs', logFileName)
					},
					{
						level: bunyan.ERROR,
						path: path.join(__dirname, '..', 'logs', logFileName)
					}
				]
				: [{
					level: bunyan.DEBUG,
					// stream: process.stdout 
                    path: path.join(__dirname, '..', 'logs', logFileName)
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
