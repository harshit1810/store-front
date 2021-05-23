const BUNYAN = require('bunyan');
const PATH = require('path');
const FS = require('fs');
// eslint-disable-next-line
const { IncomingMessage } = require('http');

module.exports = function({
	isProduction 
}) {
	const logFileName = (isProduction
		? 'prod'
		: 'dev') + '.log';
	const path = PATH.join(__dirname, '..', 'logs', logFileName);

	// remove existing log file
	FS.rmSync(path, {
		force: true
	});

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
		serializers: {
			req: requestSerializer
		},
		...(!isProduction
			? {
				src: true 
			}
			: {
			})
	});

	return logger;

	/**
	 * 
	 * @param {IncomingMessage} req 
	 */
	function requestSerializer(req) {
		return {
			method: req.method,
			url: req.url,
			headers: {
				agent: req.headers['user-agent'],
				host: req.headers['host'],
				...(!isProduction
					? {
						auth: req.headers['authorization'] 
					}
					: {
					})
			}
		};
	}
};
