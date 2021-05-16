const {
	// eslint-disable-next-line no-unused-vars
	IncomingMessage, ServerResponse 
} = require('http');
const {
	SearchApiPath 
} = require('../helpers/constants');
const SearchEngine = require('./elasticsearch');
const Event = require('../plugins/event-handler');
/* eslint-disable no-unused-vars */
module.exports = function() {
	const bonsai = SearchEngine();
	const events = Event();

	/**
	 * 
	 * @param {IncomingMessage} req 
	 */
	const basicSearch = async req => {
		/**
		 * @type {import('../plugins/event-handler').ResponseData}
		 */
		const res = {
		};
		try {
			res.responseBody = await bonsai.search({
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
		const count = await bonsai.count();
		return Object.assign(res, {
			count 
		});
	};

	const mappings = [
		{
			method: 'get',
			subPath: '',
			handler: basicSearch
		},
		{
			method: 'get',
			subPath: 'count',
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

		if (!matchingSetting) {
			return events.sendResponse({
				isError: true,
				status: 501
			});
		}
		const response = await matchingSetting.handler(req, res);
		events.sendResponse({
			...response,
			res
		});
	};

	return wrapper;
};