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
						'path': expect.any(String)
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
							'path': expect.any(String)
						}, {
							'level': 50,
							'path': expect.any(String)
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