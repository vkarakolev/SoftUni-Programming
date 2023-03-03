const expect = require('chai').expect;
const { isOddOrEven } = require ('../isOddOrEven');

describe('isOddOrEven', () => {

    it('should return undefined if parameter is not string', () => {
        let input = 5;

        let result = isOddOrEven(input);

        expect(result).to.be.undefined;
    });

    it('should return even when input has even length', () => {
        let input = 'even';

        let result = isOddOrEven(input);

        expect(result).is.equal('even');
    });

    it('should return odd when input has odd length', () => {
        let input = 'odd';

        let result = isOddOrEven(input);

        expect(result).is.equal('odd');
    });
});