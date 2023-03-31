function extendPrototype(Class) {
    Class.prototype.species = 'Human';
    Class.prototype.toSpeciesString = function () {
        return `I am a ${this.species}. ${this.toString()}`;
    }
}

class Person {
    constructor(name, email) {
        this.name = name;
        this.email = email;
    }

    toString() {
        let className = this.constructor.name;
        let result = `${className} (`;
        let properties = [];
        for(let prop of Object.keys(this)) {
            properties.push(`${prop}: ${this[`${prop}`]}`);
        }
        result += properties.join(', ');
        result += ')';
        
        return result;
    }
}

extendPrototype(Person);
let p = new Person('Maria', 'Mariaa@asd.asd');
console.log(p.toSpeciesString());