/* eslint-disable no-undef */
jest.mock('elasticsearch');
const elasticsearch = require('elasticsearch');
const plugin = require('./search-engine');
const loggerPlugin = jest.requireMock('./logger');

describe('search-engine plugin', () => {
	let isProduction;

	describe('success', () => {
		let clientSpy, client, debugSpy, infoSpy, logger, errorLogSpy;
		beforeAll(() => {
			isProduction = false;
			logger = loggerPlugin({
				isProduction
			});
			clientSpy = jest.spyOn(elasticsearch, 'Client');
			debugSpy = jest.spyOn(logger, 'debug');
			infoSpy = jest.spyOn(logger, 'info');
			errorLogSpy = jest.spyOn(logger, 'error');
		});
		beforeEach(() => {
			
			client = plugin({
				isProduction,
				logger
			});
		});
		test('add debug log', () => {
			expect(debugSpy).toHaveBeenCalledWith('Connecting to elasticsearch...');
		});
		test('show success log', () => {
			expect(infoSpy).toHaveBeenCalledWith(
				'Success: Elasticsearch connection'
			);
		});
		test('do not show any error logs', () => {
			expect(errorLogSpy).not.toHaveBeenCalled();
		});
		test('create connection', () => {
			expect(clientSpy).toHaveBeenCalledWith(
				{
					'apiVersion': '7.4',
					'host': undefined,
					'log': [{
						'levels': ['trace'],
						'type': 'stdio'
					}]
				}
			);
		});
		test('client should have methods', () => {
			expect(client).toEqual(
				{
					'count': expect.any(Function),
					'documentType': 'products',
					'index': undefined,
					'isConnected': true,
					'ping': expect.any(Function),
					'search': expect.any(Function)
				}
			);
		});
	});
	describe('failure', () => {
		let clientSpy, client, debugSpy, infoSpy, logger, errorLogSpy;
		beforeAll(() => {
			isProduction = false;
			logger = loggerPlugin({
				isProduction
			});
			clientSpy = jest.spyOn(elasticsearch, 'Client');
			debugSpy = jest.spyOn(logger, 'debug');
			infoSpy = jest.spyOn(logger, 'info');
			errorLogSpy = jest.spyOn(logger, 'error');
		});
		beforeEach(() => {
			client = plugin({
				isProduction,
				logger,
				requestTimeout: 'error'
			});
		});
		test('add debug log', () => {
			expect(debugSpy).toHaveBeenCalledWith('Connecting to elasticsearch...');
		});
		test('should not show success log', () => {
			expect(infoSpy).not.toHaveBeenCalled(
			);
		});
		test('show error log', () => {
			expect(errorLogSpy).toHaveBeenCalledWith(
				'Failed to connect to elastic search {}'
			);
		});
		test('create connection', () => {
			expect(clientSpy).toHaveBeenCalledWith(
				{
					'apiVersion': '7.4',
					'host': undefined,
					'log': [{
						'levels': ['trace'],
						'type': 'stdio'
					}]
				}
			);
		});
		test('client should have methods', () => {
			expect(client).toEqual(
				{
					'count': expect.any(Function),
					'isConnected': false,
					'ping': expect.any(Function),
					'search': expect.any(Function)
				}
			);
		});
	});
});