const expect = require('chai').expect;
const { rgbToHexColor } = require('../rgbToHex');

describe('rgbToHexColor', () => {

    it('should not return undefined with three integers between 0 and 255', () => {
        let red = 100;
        let green = 100;
        let blue = 100;

        let result = rgbToHexColor(red, green, blue);

        expect(result).not.to.be.undefined;
    });

    it('should return valid hex color with valid input', () => {
        let red = 100;
        let green = 100;
        let blue = 100;

        let result = rgbToHexColor(red, green, blue);

        expect(result).to.be.equal('#646464');
    });

    it('should return undefined when red is of invalid type', () => {
        let red = 'red';
        let green = 100;
        let blue = 100;

        let result = rgbToHexColor(red, green, blue);

        expect(result).to.be.undefined;
    });

    it('should return undefined when green is of invalid type', () => {
        let red = 100;
        let green = 'green';
        let blue = 100;

        let result = rgbToHexColor(red, green, blue);

        expect(result).to.be.undefined;
    });

    it('should return undefined when blue is of invalid type', () => {
        let red = 100;
        let green = 100;
        let blue = 'blue';

        let result = rgbToHexColor(red, green, blue);

        expect(result).to.be.undefined;
    });

    it('should return undefined when red is out of range', () => {
        let red = 256;
        let green = 100;
        let blue = 100;

        let result = rgbToHexColor(red, green, blue);

        expect(result).to.be.undefined;
    });

    it('should return undefined when green is out of range', () => {
        let red = 255;
        let green = 256;
        let blue = 100;

        let result = rgbToHexColor(red, green, blue);

        expect(result).to.be.undefined;
    });

    it('should return undefined when blue is out of range', () => {
        let red = 255;
        let green = 100;
        let blue = 256;

        let result = rgbToHexColor(red, green, blue);

        expect(result).to.be.undefined;
    });
});