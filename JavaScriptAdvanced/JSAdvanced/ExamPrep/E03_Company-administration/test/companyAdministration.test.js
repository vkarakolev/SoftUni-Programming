const companyAdministration = require('../companyAdministration');
const expect = require('chai').expect;

describe('companyAcministration', () => {
    describe('hiringEmplyee', () => {
        const empName = 'Ivan';
        const position = 'Programmer';

        it('shuold throw when position is not Programmer', () => {
            expect(() => {
                companyAdministration.hiringEmployee(empName, 'cleaner', '3');
            }).to.throw;

            try {
                companyAdministration.hiringEmployee(empName, 'cleaner', '3');
            } catch(err) {
                expect(err.message).to.equal(`We are not looking for workers for this position.`);
            }
        });

        it('should hire the Programmer successfully when XP >= 3 years', () => {
            let expected = `${empName} was successfully hired for the position ${position}.`
            expect(companyAdministration.hiringEmployee(empName, position, 3)).to.be.equal(expected);
            expect(companyAdministration.hiringEmployee(empName, position, 5)).to.be.equal(expected);
        });

        it('should not hire the Programmer with less than 3 years XP', () => {
            let expected = `${empName} is not approved for this position.`;
            expect(companyAdministration.hiringEmployee(empName, position, 2)).to.be.equal(expected);
            expect(companyAdministration.hiringEmployee(empName, position, 0)).to.be.equal(expected);
        });
    });

    describe('calculateSalary', () => {
        let payPerHour = 15;
        let hours = 160;

        it('should pay salary equal to 15 BGN for hour', () => {
            let total = payPerHour * hours;
            expect(companyAdministration.calculateSalary(160)).to.be.equal(total);
            expect(companyAdministration.calculateSalary(160)).to.be.equal(2400);
            expect(companyAdministration.calculateSalary(160) / hours).to.be.equal(payPerHour);
        });

        it('should pay 1000 BGN bonus when hours > 160', () => {
            expect(companyAdministration.calculateSalary(161)).to.be.equal(3415);
        });

        it('should throw when hours is a negative number', () => {
            expect(() => {
                companyAdministration.calculateSalary(-1);
            }).to.throw;
        });

        it('should throw when hours is not a number', () => {
            expect(() => {
                companyAdministration.calculateSalary('10');
            }).to.throw;
        });
    });

    describe('firedEmployee', () => {
        let employees = ["Petar", "Ivan", "George"];

        it('should remove the employee of given index', () => {
            let expected = ["Petar", "Ivan"];
            expect(companyAdministration.firedEmployee(employees, 2)).to.be.equal(expected.join(', '));
        });

        it('should throw when employees is not an array', () => {
            expect(() => {
                companyAdministration.firedEmployee('10', 2);
            }).to.throw;
            expect(() => {
                companyAdministration.firedEmployee(2, 2);
            }).to.throw;
        });

        it('should throw when index is not a number', () => {
            expect(() => {
                companyAdministration.firedEmployee(employees, '12');
            }).to.throw;
        });

        it('should throw when index is a negative number', () => {
            expect(() => {
                companyAdministration.firedEmployee(employees, -1);
            }).to.throw;
        });

        it('should throw when index is equal to arr.length', () => {
            expect(() => {
                companyAdministration.firedEmployee(employees, 3);
            }).to.throw;
        });
    });
});