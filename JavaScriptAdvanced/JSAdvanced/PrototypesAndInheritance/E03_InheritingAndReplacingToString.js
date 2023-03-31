function toStringExtension() {
    class Person {
        constructor(personName, email) {
            this.name = personName;
            this.email = email;
        }
    }

    Person.prototype.toString = function() {
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

    class Teacher extends Person {
        constructor (name, email, subject) {
            super(name, email);
            this.subject = subject;
        }
    }

    class Student extends Person {
        constructor(name, email, course) {
            super(name, email);
            this.course = course;
        }
    }

    return { 
        Person, 
        Teacher,
        Student
    }
}

let classes = toStringExtension();
let Person = classes.Person;
let p = new Person('Pesho', 'pesho@asd.asd');
console.log(p.toString())