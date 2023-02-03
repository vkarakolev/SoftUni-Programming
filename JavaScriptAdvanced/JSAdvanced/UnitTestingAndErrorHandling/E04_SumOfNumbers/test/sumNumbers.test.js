const expect = require('chai').expect;
const { sum } = require('../sumNumbers');

describe('sum', () => {

    it('should not throw exception with an array of numbers as an argument.', () => {
        //Arrange
        let arr = [2, 2, 2];

        //Act
        let result = sum(arr);

        //Assert
        expect(result).not.to.throw;
    });

    it('should return sum of all elements of the array', () => {
        //Arrange
        let arr = [2, 2, 2];

        //Act
        let result = sum(arr);

        //Assert
        expect(result).to.be.equal(6);
    })
});