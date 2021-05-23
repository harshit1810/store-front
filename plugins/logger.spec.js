/* eslint-disable no-undef */
const bunyan = require('bunyan');
const loggerPlugin = require('./logger');

describe('logger plugin', () => {
	describe('success', () => {
		describe('in dev env', () => {
			let createLoggerSpy, logger;
			beforeAll(() => {
				createLoggerSpy = jest.spyOn(bunyan, 'createLogger');
			});
			beforeEach(() => {
				logger = loggerPlugin({
					isProduction: false
				});
			});
			test('creates logger instance', () => {
				expect(createLoggerSpy).toHaveBeenCalledWith({
					'name': 'search-service',
					'serializers': {
						'req': expect.any(Function)
					},
					'src': true,
					'streams': [{
						'level': 20,
						'path': 'D:\\Workspace\\github\\store-front\\logs\\dev.log'
					}]
				});
			});
			test('logger should have methods for logging', () => {
				expect(logger).toEqual(
					expect.objectContaining({
						debug: expect.any(Function),
						info: expect.any(Function),
						warn: expect.any(Function),
						error: expect.any(Function)
					})
				);
			});
		});
		describe('in production env', () => {
			let createLoggerSpy, logger;
			beforeAll(() => {
				createLoggerSpy = jest.spyOn(bunyan, 'createLogger');
			});
			beforeEach(() => {
				logger = loggerPlugin({
					isProduction: true
				});
			});
			test('creates logger instance', () => {
				expect(createLoggerSpy).toHaveBeenCalledWith(
					{
						'name': 'search-service',
						'serializers': {
							'req': expect.any(Function)
						},
						'streams': [{
							'level': 40,
							'path': 'D:\\Workspace\\github\\store-front\\logs\\prod.log'
						}, {
							'level': 50,
							'path': 'D:\\Workspace\\github\\store-front\\logs\\prod.log'
						}]
					}
				);
			});
			test('logger should have methods for logging', () => {
				expect(logger).toEqual(
					expect.objectContaining({
						debug: expect.any(Function),
						info: expect.any(Function),
						warn: expect.any(Function),
						error: expect.any(Function)
					})
				);
			});
		});
	});
});