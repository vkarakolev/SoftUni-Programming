const expect = require('chai').expect;
const { createCalculator } = require('../addSubtract');

describe('createCalculator', () => {
   
    it('should return object with three functions (add, subtract, get)', () => {
        let result = createCalculator();

        expect(result).to.be.an('object');
        expect(result).to.include(function add(){}, function subtract(){}, function get(){}); 
    });

    it('should work correct with parameter that can be parsed to number'), () => {
        let num = '6';
        
        let calc = createCalculator();
        calc.add(num);

        expect(calc.get()).to.be.equal(6)
    }
});