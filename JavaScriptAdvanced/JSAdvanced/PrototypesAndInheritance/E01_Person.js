function createPerson(firstName, lastName) {
    return {
        firstName: firstName,
        lastName: lastName,
        get fullName() {
            return this.firstName + ' ' + this.lastName;
        },
        set fullName(value) {
            let input = value.split(' ');
            if(input.length !== 2) {
                return;
            }

            this.firstName = input[0];
            this.lastName = input[1];
        }
    }
}

let person = createPerson("Peter", "Ivanov");
console.log(person.fullName); //Peter Ivanov
person.firstName = "George";
console.log(person.fullName); //George Ivanov
person.lastName = "Peterson";
console.log(person.fullName); //George Peterson
person.fullName = "Nikola Tesla";
console.log(person.firstName); //Nikola
console.log(person.lastName); //Tesla

console.log('');

let person1 = createPerson("Albert", "Simpson");
console.log(person1.fullName); //Albert Simpson
person1.firstName = "Simon";
console.log(person1.fullName); //Simon Simpson
person1.fullName = "Peter";
console.log(person1.firstName); // Simon
console.log(person1.lastName); // Simpson