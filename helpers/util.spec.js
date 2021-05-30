/* eslint-disable no-undef */
const util = require('./util');

describe('util', () => {
	describe('isNonEmptyArray', () => {
		describe('positive', () => {
			test('should be ok', () => {
				expect(
					util.isNonEmptyArray(['a', 'b'])
				).toBe(true);
			});
		});
		describe('negative', () => {
			test('should fail for empty array', () => {
				expect(
					util.isNonEmptyArray([])
				).toBe(false);
			});
			test('should fail for object', () => {
				expect(
					util.isNonEmptyArray({
					})
				).toBe(false);
			});
			test('should fail for string', () => {
				expect(
					util.isNonEmptyArray('asdas')
				).toBe(false);
			});
			test('should fail for undefined', () => {
				expect(
					util.isNonEmptyArray(undefined)
				).toBe(false);
			});
		});
	});
	describe('isNonEmptyString', () => {
		describe('positive', () => {
			test('should pass', () => {
				expect(
					util.isNonEmptyString('    erge erhogne ')
				).toBe(true);
			});
		});
		describe('negative', () => {
			test('should fail for empty string', () => {
				expect(
					util.isNonEmptyString('     ')
				).toBe(false);
			});
			test('should fail for array', () => {
				expect(
					util.isNonEmptyString([''])
				).toBe(false);
			});
			test('should fail for object', () => {
				expect(
					util.isNonEmptyString({
					})
				).toBe(false);
			});
			test('should fail for undefined', () => {
				expect(
					util.isNonEmptyString(undefined)
				).toBe(false);
			});
		});
	});
});