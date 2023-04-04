const bookSelection = require('../bookSelection');
let expect = require('chai').expect;

describe('bookSelection', () => {
    describe('isGenreSuitable', () => {
        it('should return not suitable... when age is less or equal 12 and genre is Thriller', () => {
            let genre = 'Thriller';
            let age = 12;
            let expected = `Books with ${genre} genre are not suitable for kids at ${age} age`;
            expect(bookSelection.isGenreSuitable(genre, age)).to.be.equal(expected);
        });

        it('should return not suitable... when age is less or equal 12 and genre is Horror', () => {
            let genre = 'Horror';
            let age = 12;
            let expected = `Books with ${genre} genre are not suitable for kids at ${age} age`;
            expect(bookSelection.isGenreSuitable(genre, age)).to.be.equal(expected);
        });

        it('should return suitable when age is above 12', () => {
            let expected = `Those books are suitable`
            expect(bookSelection.isGenreSuitable('Horror', 13)).to.be.equal(expected);
            expect(bookSelection.isGenreSuitable('Horror', 20)).to.be.equal(expected);
            expect(bookSelection.isGenreSuitable('Thriller', 13)).to.be.equal(expected);
            expect(bookSelection.isGenreSuitable('Thriller', 20)).to.be.equal(expected);

        });
    });

    describe('isItAffordable', () => {
        it('should return not enough money when peice is bigger than the budget', () => {
            expect(bookSelection.isItAffordable(21, 20)).to.be.equal("You don't have enough money");
        });

        it('should successfully buy the book when price is less than the budget', () => {
            expect(bookSelection.isItAffordable(10, 11)).to.be.equal(`Book bought. You have 1$ left`);
        });

        it('should throw when price is not a number', () => {
            expect(() => {
                bookSelection.isItAffordable('20', 10);
            }).to.throw;
        });

        it('should throw when budget is not a number', () => {
            expect(() => {
                bookSelection.isItAffordable(20, '10');
            }).to.throw;
        });
    });

    describe('suitableTitles', () => {
        it('should throw when first parameter is not an array', () => {
            expect(() => {
                bookSelection.suitableTitles('book', 'genre');
            }).to.throw;
        });

        it('should throw when second parameter is not a string', () => {
            expect(() => {
                bookSelection.suitableTitles([{}, {}], 12);
            }).to.throw;
        });

        it('should work correct when properties are correct', () => {
            let books = [
                {title: "0", genre: "Thriller"},
                {title: "1", genre: "Thriller"},
                {title: "2", genre: "Horror"},
                {title: "3", genre: "Commedy"},
            ];
            let result = ['0', '1'];

            expect(bookSelection.suitableTitles(books, 'Thriller').join(' ')).to.be.equal(result.join(' '));
        });
    });
});