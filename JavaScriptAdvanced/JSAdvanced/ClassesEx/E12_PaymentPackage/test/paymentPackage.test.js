const expect = require('chai').expect;
const PaymentPackage = require('../paymentPackage');

describe('PaymentPackage', () => {
    describe('create instance', () => {
        let paymentPackage;
        
        beforeEach(() => {
            paymentPackage = new PaymentPackage('Ivan', 10);
        });

        it('name should be equal to the given argument', () => {
            expect(paymentPackage._name).to.be.equal('Ivan');
        });

        it('value should be equal to the given argument', () => {
            expect(paymentPackage._value).to.be.equal(10);
        });

        it('VAT should be equal to the default value', () => {
            expect(paymentPackage._VAT).to.be.equal(20);
        });

        it('active status should be equal to the default value', () => {
            expect(paymentPackage._active).to.be.true;
        });
    });

    describe('test setters', () => {
        describe('set name', () => {
            it('should throw when the given value is not a string', () => {
                expect(() => {
                    new PaymentPackage(20, 20);
                }).to.throw;
            });

            it('should throw when the given value is an empty string', ()=> {
                expect(() => {
                    new PaymentPackage('', 20);
                }).to.throw;
            });

            it('should set a correct value', () => {
                let paymentPackage = new PaymentPackage('Ivan', 10);
                expect(paymentPackage.name).to.be.equal('Ivan');
                paymentPackage.name = 'Georgi';
                expect(paymentPackage.name).to.be.equal('Georgi');
            });
        });

        describe('set value', () => {
            it('should throw when the given value is not a number', () => {
                expect(() => {
                    new PaymentPackage('Ivan', '3');
                }).to.throw;
            });

            it('should throw when the given value is a negative number', ()=> {
                expect(() => {
                    new PaymentPackage('Ivan', -20);
                }).to.throw;
            });

            it('should set a correct value', () => {
                let paymentPackage = new PaymentPackage('Ivan', 10);
                expect(paymentPackage.value).to.be.equal(10);
                paymentPackage.value = 0;
                expect(paymentPackage.value).to.be.equal(0);
            });
        });

        describe('set VAT', () => {
            it('should throw when the given value is not a number', () => {
                let paymentPackage = new PaymentPackage('Ivan', 10);
                expect(() => {
                    paymentPackage.VAT = '10';
                }).to.throw;
            });

            it('should throw when the given value is a negative number', ()=> {
                let paymentPackage = new PaymentPackage('Ivan', 10);
                expect(() => {
                    paymentPackage.VAT = -10;
                }).to.throw;
            });

            it('should set a correct value', () => {
                let paymentPackage = new PaymentPackage('Ivan', 10);
                expect(paymentPackage.VAT).to.be.equal(20);
                paymentPackage.VAT = 10;
                expect(paymentPackage.VAT).to.be.equal(10);
            });
        });

        describe('set active', () => {
            it('should throw when the given value is not of type boolean', () => {
                let paymentPackage = new PaymentPackage('Ivan', 10);
                expect(() => {
                    paymentPackage.active = 'false';
                }).to.throw;
            });

            it('should set a correct value', () => {
                let paymentPackage = new PaymentPackage('Ivan', 10);
                expect(paymentPackage.active).to.be.true;
                paymentPackage.active = false;
                expect(paymentPackage.active).to.be.false;
            });
        });
    });

    describe('toString', () => {
        let paymentPackage;
        beforeEach(() => {
            paymentPackage = new PaymentPackage('Ivan', 10);
        });

        it('should print correct value when active is true', () => {
            const output = [ 
                `Package: Ivan`, 
                `- Value (excl. VAT): 10`,
                `- Value (VAT 20%): ${10 * (1 + 20 / 100)}` 
            ].join('\n'); 
            expect(paymentPackage.toString()).to.be.equal(output);
        });

        it('should print correct value when active is false', () => {
            const output = [ 
                `Package: Ivan (inactive)`, 
                `- Value (excl. VAT): 10`,
                `- Value (VAT 20%): ${10 * (1 + 20 / 100)}` 
            ].join('\n'); 
            paymentPackage.active = false;
            expect(paymentPackage.toString()).to.be.equal(output);
        });
    });
});