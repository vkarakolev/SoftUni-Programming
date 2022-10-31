function lowestPrices(input) {
    let result = {};

    for(let i of input) {
        let [town, product, price] = i.split(' | ');
        price = Number(price);

        if(!result.hasOwnProperty(product) || price < result[product].price) {
            result[product] = {town, price};
        }
    }

    let entries = Object.entries(result);

    for(let [key, value] of entries) {
       console.log(`${key} -> ${value.price} (${value.town})`);
    }
}

lowestPrices([
    'Sample Town | Sample Product | 1000',
    'Sample Town | Orange | 2',
    'Sample Town | Peach | 1',
    'Sofia | Orange | 3',
    'Sofia | Peach | 2',
    'New York | Sample Product | 1000.1',
    'New York | Burger | 10'
]);