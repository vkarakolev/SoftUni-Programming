const expect = require('chai').expect;
const { isSymmetric} = require('../checkForSymmetry');

describe('isSymmetric', () => {
    it('should not throw with an array as argument', () => {
        let arr = [2, 2, 2];
        let result = isSymmetric(arr);
        expect(result).not.to.throw;
    });

    it('should return false with invalid input', () => {
        let arr = 'invalid';
        let result = isSymmetric(arr);
        expect(result).to.be.false;
    });

    it('should return true if the input array is symmetric', () => {
        let arr = [1, 2, 3, 2, 1];
        let result = isSymmetric(arr);
        expect(result).to.be.true;
    });

    it('should retunr false if input array is not symmetric', () => {
        let arr = [1, 2, 3, 4];
        let result = isSymmetric(arr);
        expect(result).to.be.false;
    });
});