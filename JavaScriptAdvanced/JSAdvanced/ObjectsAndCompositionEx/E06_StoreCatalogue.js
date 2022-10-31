function catalogueSort(input) {
    input.sort();

    let products = {};

    for(let i of input) {
        let [product, price] = i.split(' : ');
        products[product] = price;
    }

    let entries = Object.entries(products);
    let currentInitial;
    for(let [key, value] of entries) {

        if(key.charAt(0) !== currentInitial) {
            currentInitial = key.charAt(0);
            console.log(currentInitial);
        }

        console.log(`  ${key}: ${value}`);
    }
}

catalogueSort([
    'Appricot : 20.4',
    'Fridge : 1500', 
    'TV : 1499', 
    'Deodorant : 10', 
    'Boiler : 300', 
    'Apple : 1.25', 
    'Anti-Bug Spray : 15', 
    'T-Shirt : 10'
]);

catalogueSort([
    'Banana : 2',
    'Rubic\'s Cube : 5', 
    'Raspberry P : 4999', 
    'Rolex : 100000', 
    'Rollon : 10', 
    'Rali Car : 2000000', 
    'Pesho : 0.000001', 
    'Barrel : 10'
]);