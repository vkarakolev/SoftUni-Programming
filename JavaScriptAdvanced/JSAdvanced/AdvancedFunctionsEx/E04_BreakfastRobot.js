function solution() {
    let storage = {
        protein: 0,
        carbohydrate: 0,
        fat: 0,
        flavour: 0
    }

    let recipes = {
        apple: {carbohydrate: 1, flavour: 2},
        lemonade: {carbohydrate: 10, flavour: 20},
        burger: {carbohydrate: 5, fat: 7, flavour: 3},
        eggs: {protein: 5,fat: 1, flavour: 1},
        turkey: {protein: 10, carbohydrate: 10, fat: 10, flavour:10}
    };

    return function(input) {
        let [command, arg, quantity] = input.split(' ');

        switch(command) {
            case 'restock': return restock(arg, quantity);
            case 'prepare': return prepare(arg, quantity);
            case 'report': return report();
        }
    }

    function restock(ingredient, quantity) {
        storage[ingredient] += Number(quantity);
        return 'Success';
    }

    function prepare(recipe, quantity) {
        let currentRecipe = recipes[recipe];
        
        for(let [k, v] of Object.entries(currentRecipe)) {
            if(storage[k] < v * quantity) {
                return `Error: not enough ${k} in stock`;
            }
        }
        
        for(let [k, v] of Object.entries(currentRecipe)) {
            storage[k] -= v * quantity
        }

        return 'Success';
    }

    function report() {
        return `protein=${storage.protein} carbohydrate=${storage.carbohydrate} fat=${storage.fat} flavour=${storage.flavour}`;
    }
}

let manager = solution ();
console.log (manager ('restock flavour 50')); // Success
console.log (manager ('prepare lemonade 4')); // Error: not enough carbohydrate in stock
console.log (manager ('restock carbohydrate 10'));
console.log (manager ('restock flavour 10'));
console.log (manager ('prepare apple 1'));
console.log (manager ('restock fat 10'));
console.log (manager ('prepare burger 1'));
console.log (manager ('report'));

// console.log(`\n`);

// console.log (manager ('prepare turkey 1'));
// console.log (manager ('restock protein 10'));
// console.log (manager ('prepare turkey 1'));
// console.log (manager ('restock carbohydrate 10'));
// console.log (manager ('prepare turkey 1'));
// console.log (manager ('restock fat 10'));
// console.log (manager ('prepare turkey 1'));
// console.log (manager ('restock flavour 10'));
// console.log (manager ('prepare turkey 1'));
// console.log (manager ('report'));