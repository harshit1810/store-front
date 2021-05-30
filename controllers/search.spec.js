/* eslint-disable no-undef */
const service = jest.requireMock('../service/es');
const loggerPlugin = jest.requireMock('../plugins/logger');
const searchCtrl = require('./search');
const {
	SearchApiPath,
	// eslint-disable-next-line no-unused-vars
	SearchApiName 
} = require('../helpers/constants');

const isProduction = false,
	defaultResponse = {
		writeHead: jest.fn(),
		end: jest.fn()
	};
let logger = loggerPlugin({
		isProduction
	}), searchService = service({
		isProduction
	});
describe('search controller', () => {
	let controller;
	beforeAll(() => {
		controller = searchCtrl({
			isProduction,
			logger,
			searchService
		});
	});
	describe('on search request', () => {
		let debugLogSpy, request, searchSpy;
		beforeEach(async () => {
			debugLogSpy = jest.spyOn(logger, 'debug');
			searchSpy = jest.spyOn(searchService, 'search');
			request = {
				method: 'GET',
				url: SearchApiPath
			};
			await controller(request, defaultResponse);
		});
		test('show debug log', () => {
			expect(debugLogSpy).toHaveBeenCalledWith('inside basicSearch');
		});
		test('search in search engine', () => {
			expect(searchSpy).toHaveBeenCalledWith({
				'query': ''
			});
		});
	});
});