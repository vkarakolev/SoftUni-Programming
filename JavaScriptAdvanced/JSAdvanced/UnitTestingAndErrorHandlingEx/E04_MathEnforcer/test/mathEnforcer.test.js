const expect = require('chai').expect;
const { addFive, subtractTen, sum} = require('../mathEnforcer');

describe('mathEnforcer', () => {
    describe('addFive', () => {
        it('should return undefined when given parameter is not a number', () => {
            let param = 'str';

            let result = addFive(param);

            expect(result).to.be.undefined;
        });

        it('should add five to positive parameter', () => {
            let param = 5;

            let result = addFive(param);

            expect(result).is.equal(10);
        });

        it('should add five to negative parameter', () => {
            let param = -5;

            let result = addFive(param);

            expect(result).is.equal(0);
        });

        it('should add five to a floating-point parameter', () => {
            let param = 5.5;

            let result = addFive(param);

            expect(result).to.be.closeTo(10.5, 0.01);
        });
    });

    describe('subtractTen', () => {
        it('should return undefined when given parameter is not a number', () => {
            let param = 'str';

            let result = subtractTen(param);

            expect(result).to.be.undefined;
        });

        it('should subtract ten from positive parameter', () => {
            let param = 5;

            let result = subtractTen(param);

            expect(result).is.equal(-5);
        });

        it('should subtract ten from negative parameter', () => {
            let param = -5;

            let result = subtractTen(param);

            expect(result).is.equal(-15);
        });

        it('should subtract ten from a floating-point parameter', () => {
            let param = 5.5;

            let result = subtractTen(param);

            expect(result).to.be.closeTo(-4.5, 0.01);
        });
    });

    describe('sum', () => {
        it('should return undefined when first parameter is not a number', () => {
            let param1 = 'str';
            let param2 = 1;

            let result = sum(param1, param2);

            expect(result).to.be.undefined;
        });

        it('should return undefined when second parameter is not a number', () => {
            let param1 = 1;
            let param2 = 'str';

            let result = sum(param1, param2);

            expect(result).to.be.undefined;
        });

        it('should return the sum of positive parameters', () => {
            let param1 = 5;
            let param2 = 10

            let result = sum(param1, param2);

            expect(result).is.equal(15);
        });

        it('should return the sum of negative parameters', () => {
            let param1 = -5;
            let param2 = -10

            let result = sum(param1, param2);

            expect(result).is.equal(-15);
        });

        it('should return the sum of floating-point parameters', () => {
            let param1 = 5.5;
            let param2 = -10.5

            let result = sum(param1, param2);

            expect(result).to.be.closeTo(-5, 0.01);
        });
    });
});