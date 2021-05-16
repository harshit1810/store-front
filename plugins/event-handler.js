/**
 * @typedef {{
 * isError: boolean,  
 * status: number | undefined,
 * headers: {[headerName: string]: string|string[]},
 * errorMessage: string | undefined,
 * res: ServerResponse,
 * responseBody: {}
 * }} ResponseData
 */
const EventEmitter = require('events');
const {
	// eslint-disable-next-line no-unused-vars
	ServerResponse 
} = require('http');
class MyEmitter extends EventEmitter {
	constructor() {
		super();
		this.commonHeaders = {
			'Content-Type': 'application/json'
		};
		this.on('SendResponse',
			/**
             * @param {ResponseData} data
             */
			data => {
				if (!data.status) {
					data.status = data.isError
						? 500
						: 200;
				}
				const error = data.isError && typeof data.errorMessage === 'string'
					? data.errorMessage
					: '';
				data.res.writeHead(data.status, {
					...(data.headers || {
					}),
					...this.commonHeaders
				});
				const body = data.isError
					? {
						error 
					}
					: {
						body: data.responseBody
					};
				data.res.end(Buffer.from(JSON.stringify(body), 'utf8'));
			});
	}

	/**
     * @param {ResponseData} data
     */
	sendResponse(data) {
		this.emit('SendResponse', data);
	}
}

module.exports = function () {
	let myEmitter;

	function createInstance() {
		myEmitter = new MyEmitter();
		return myEmitter;
	}

	return typeof myEmitter === 'undefined'
		? createInstance()
		: myEmitter;
};

