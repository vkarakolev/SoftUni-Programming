const weddingDay = require('../weddingDay');
const expect = require('chai').expect;

describe('weddingDay', () => {
    describe('pickVenue', () => {
        it('should throw when first param is not a number', () => {
            expect(() => {
                weddingDay.pickVenue('10', 10, 'Plovdiv');
            }).to.throw;
        });

        it('should throw when second param is not a number', () => {
            expect(() => {
                weddingDay.pickVenue(100, '10', 'Varna');
            }).to.throw;
        });

        it('should throw when first param is invalid', () => {
            expect(() => {
                weddingDay.pickVenue(100, 10, 10);
            }).to.throw;

            expect(() => {
                weddingDay.pickVenue(100, 10, '');
            }).to.throw;

            expect(() => {
                weddingDay.pickVenue(10, 10, []);
            }).to.throw;

            expect(() => {
                weddingDay.pickVenue(10, 10, {});
            }).to.throw;
               
            try {
                weddingDay.pickVenue(10, 10, '');
            } catch (err) {
                expect(err.message).to.be.equal(`Invalid Information!`);
            }
        });

        it('should throw when location param is not a Varna', () => {
            expect(() => {
                weddingDay.pickVenue(100, 10, 'Plovdiv');
            }).to.throw;
        });

        let capacity = 150;
        let pricePerGuest = 120;
        let location = 'Varna';

        it('should work correctly with valid params', () => {
            let expResult = `This venue meets the requirements, with capacity of ${capacity} guests and ${pricePerGuest}$ cover.`;
            expect(weddingDay.pickVenue(capacity, pricePerGuest, location)).to.be.equal(expResult);
        });

        it('should return that you dont meet the requirements', () => {
            let expResult = `This venue does not meet your requirements!`;
            expect(weddingDay.pickVenue(149, pricePerGuest, location)).to.be.equal(expResult);
            expect(weddingDay.pickVenue(capacity, 121, location)).to.be.equal(expResult);
            expect(weddingDay.pickVenue(100, pricePerGuest, location)).to.be.equal(expResult);
            expect(weddingDay.pickVenue(capacity, 150, location)).to.be.equal(expResult);
        });
    });
    
    describe('otherSpendings', () => {
    let weddingDecoration = ['flowers', 'Fabric drapes and curtains'];
    let photography = ['pictures', 'video'];
    let totalPrice = 2900;
    let discount = totalPrice * 0.15;

        it('should return correct price without discount', () => {
            let expResult = `You spend ${totalPrice}$ for wedding decoration and photography!`;
            expect(weddingDay.otherSpendings(weddingDecoration, photography, false)).to.be.equal(expResult);
        });

        it('should return correct price with discount', () => {
            let expResult = `You spend ${totalPrice - discount}$ for wedding decoration and photography with 15% discount!`;
            expect(weddingDay.otherSpendings(weddingDecoration, photography, true)).to.be.equal(expResult);
        });

        it('should throw when weddingDecoration param is not an array', () => {
            expect(() => {
                weddingDay.otherSpendings(100, ['video'], false);
            }).to.throw;
        });

        it('should throw when photography param is not an array', () => {
            expect(() => {
                weddingDay.otherSpendings(['flowers'], 'video', true);
            }).to.throw;
        });

        it('should throw when weddingDecoration param is not an array', () => {
            expect(() => {
                weddingDay.otherSpendings(['flowers'], ['video'], 10);
            }).to.throw;
        });
    });
    
    describe('tableDistribution', () => {
        let guests = 100;
        let tables = 20;
        let peopleOnTable = Math.round(guests / tables);

        it('should return correct price with discount', () => {
            let expResult = `There is only ${peopleOnTable} people on every table, you can join some tables.`;
            expect(weddingDay.tableDistribution(guests, tables)).to.be.equal(expResult);
        });
    });
});