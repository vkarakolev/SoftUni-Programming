(function solve() {
    Array.prototype.last = function () {
        return this[this.length - 1];
    };

    Array.prototype.skip = function (n) {
        let newArr = [];

        for (let i = n; i < this.length; i++) {
            newArr.push(this[i]);
        }

        return newArr;
    };

    Array.prototype.take = function (n) {
        let newArr = [];

        for (let i = 0; i < n; i++) {
            newArr.push(this[i]);
        }

        return newArr;
    };

    Array.prototype.sum = function () {
        let sum = 0;

        for (let e of this) {
            sum += e;
        }

        return sum;
    }

    Array.prototype.average = function () {
        return this.sum() / this.length;
    };
})();

myArr = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
console.log(myArr.last());
console.log(myArr.skip(4));
console.log(myArr.take(6));
console.log(myArr.sum());
console.log(myArr.average());