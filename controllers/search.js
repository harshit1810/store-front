/* eslint-disable no-unused-vars */
const {
	// eslint-disable-next-line no-unused-vars
	IncomingMessage, ServerResponse 
} = require('http');
const {
	SearchApiPath 
} = require('../helpers/constants');
const {
	isNonEmptyArray 
} = require('../helpers/util');
const Event = require('../plugins/event-handler');
/**
 * 
 * @param {Object} config
 * @param {boolean} config.isProduction
 * @param {{}} config.logger
 * @param {{}} config.searchService
 * @returns 
 */
module.exports = function(config) {
	const {
		searchService,
		logger
	} = config;
	const events = Event();

	/**
	 * 
	 * @param {IncomingMessage} req 
	 */
	const basicSearch = async req => {
		logger.debug(`inside ${__filename} -> basicSearch`);
		/**
		 * @type {import('../plugins/event-handler').ResponseData}
		 */
		const res = {
		};
		try {
			res.responseBody = await searchService.search({
				query: ''
			});
			res.responseBody;
		} catch(e) {
			res.isError = true;
			res.errorMessage = 'Failed to search';
		}
		return res;
	};

	/**
	 * 
	 * @param {IncomingMessage} req 
	 * @returns {import('../plugins/event-handler').ResponseData}
	 */
	const getCount = async req => {
		/**
		 * @type {import('../plugins/event-handler').ResponseData}
		 */
		const res = {
		};
		const count = await searchService.count();
		return Object.assign(res, {
			count 
		});
	};

	const mappings = [
		{
			method: 'get',
			subPath: '',
			validators: [],
			sanitizers: [],
			handler: basicSearch
		},
		{
			method: 'get',
			subPath: 'count',
			validators: [],
			sanitizers: [],
			handler: getCount
		}
	];

	/**
	 * 
	 * @param {IncomingMessage} req 
	 * @param {ServerResponse} res 
	 */
	const wrapper = async (req, res) => {
		const method = String(req.method).trim().toLowerCase();
		const [, endpointPath] = req.url.split(SearchApiPath);
		const [, ...parts] = endpointPath.split('/');
		const subPath = parts[0] || '';

		const matchingSetting = mappings.find(_map => {
			return _map.method === method && _map.subPath === subPath;
		});

		const reply = obj => {
			return events.sendResponse({
				...obj,
				res
			});
		};

		// throw 'Not Implemented' error if the endpoint is not mapped to a function
		if (!matchingSetting) {
			logger.warn('Endpoint is not mapped');
			return reply({
				isError: true,
				status: 501
			});
		}

		// invoke validators
		if (isNonEmptyArray(matchingSetting.validators)) {
			for (let i=0;i<matchingSetting.validators.length; i++) {
				const fn = matchingSetting.validators[i];
				if (typeof fn !== 'function') {
					continue;
				}
				try {
					await fn(req);
				} catch(obj) {
					logger.error('Error occured during validation');
					return reply(obj);
				}
			}
		}

		// invoke sanitizers
		if (isNonEmptyArray(matchingSetting.sanitizers)) {
			matchingSetting.sanitizers.forEach(fn => {
				return fn(req);
			});
		}

		// invoke handler function
		const response = await matchingSetting.handler(req, res);
		reply(response);
	};

	return wrapper;
};