(function solve() {
    String.prototype.ensureStart = function (str) {
        let start = this.substring(0, str.length);
        if (start === str) {
            return this.toString();
        }
        return str + this;
    };

    String.prototype.ensureEnd = function (str) {
        let end = this.substring(this.length - str.length, this.length);
        if (end === str) {
            return this.toString();
        }
        return this + str;
    };

    String.prototype.isEmpty = function () {
        if (this.length === 0 || this === null || this === undefined) {
            return true;
        }
        return false;
    };
})();

let str = 'my string';
str = str.ensureStart('my');
console.log(str);
str = str.ensureStart('hello ');
console.log(str);
str = str.ensureEnd('!');
console.log(str);
console.log(str.isEmpty())