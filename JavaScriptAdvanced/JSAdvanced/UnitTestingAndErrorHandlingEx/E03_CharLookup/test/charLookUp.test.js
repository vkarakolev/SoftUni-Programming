const expect = require('chai').expect;
const { lookupChar } = require('../charLookUp');

describe('lookupChar', () => {
    it('should return undefined when first parameter is not string', () => {
        let first = 1;
        let second = 2;

        let result = lookupChar(first, second);

        expect(result).to.be.undefined;
    });

    it('should return undefined when second parameter is not a number', () => {
        let first = 'str1';
        let second = 'str2';

        let result = lookupChar(first, second);

        expect(result).to.be.undefined;
    });

    it('should return incorrect index when index is bigger than the length of the string', () => {
        let first = 'string';
        let second = 7;

        let result = lookupChar(first, second);

        expect(result).is.equal('Incorrect index');
    });

    it('should return incorrect index when index is equal to the length of the string', () => {
        let first = 'string';
        let second = 6;

        let result = lookupChar(first, second);

        expect(result).is.equal('Incorrect index');
    });

    it('should return incorrect index when index is a negative nuber', () => {
        let first = 'string';
        let second = -1;

        let result = lookupChar(first, second);

        expect(result).is.equal('Incorrect index');
    });

    it('should return the character on the given index', () => {
        let first = 'string';
        let second = 2;

        let result = lookupChar(first, second);

        expect(result).is.equal('r');
    });
});