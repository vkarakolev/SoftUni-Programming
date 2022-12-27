function fruitPrice(fruit, grams, price) {
    let kg = grams / 1000;
    let totalPrice = price * kg;

    console.log(`I need \$${totalPrice.toFixed(2)} to buy ${kg.toFixed(2)} kilograms ${fruit}.`)
}

fruitPrice('orange', 2500, 1.80);
fruitPrice('apple', 1563, 2.35);