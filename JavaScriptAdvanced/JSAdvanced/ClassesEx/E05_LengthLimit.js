class Stringer {
    constructor(string, length) {
        this._initial = string;
        this.innerString = string;
        this.innerLength = length;
    }    

    increase(length) {
        this.innerLength += length;
    }

    decrease(length) {
        this.innerLength -= length;

        if(this.innerLength < 0) {
            this.innerLength = 0;
        }
    }

    toString() {
        let result = this.innerString.slice(0, this.innerLength);

        if(this.innerLength < this._initial.length) {
            result += '...';
        }

        return result;
    }
}

let test = new Stringer("Test", 5);
console.log(test.toString()); // Test
test.decrease(3);
console.log(test.toString()); // Te...
test.decrease(7);
console.log(test.toString()); // ...
test.increase(6);
console.log(test.toString()); // Test