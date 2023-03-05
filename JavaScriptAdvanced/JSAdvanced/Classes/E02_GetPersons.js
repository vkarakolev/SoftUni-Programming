const Person = require('./E01_Person');

function personArray() {
    return Array.of(
        new Person ('Anna', 'Simpson', 22, 'anna@yahoo.com'),
        new Person ('SoftUni'),
        new Person ('Stephan', 'Johnson', 25),
        new Person ('Gabriel', 'Peterson', 24, 'g.p@gmail.com')
    )
}

console.log(personArray());