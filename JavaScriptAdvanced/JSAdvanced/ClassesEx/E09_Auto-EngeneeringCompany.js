function autoCompany(input) {
    let brandsMap = new Map();
    
    for(let e of input) {
        let [brand, model, quantity] = e.split(' | ');

        if(!brandsMap.has(brand)) {
            brandsMap.set(brand, new Map());
        }
        
        if(!brandsMap.get(brand).has(model)) {
            brandsMap.get(brand).set(model, Number(0));
        }

        brandsMap.get(brand).set(model, brandsMap.get(brand).get(model) + Number(quantity));
    }

    let output = [];
    for(let br of brandsMap.entries()){
        output.push(br[0]);
        for(let m of br[1]) {
            output.push(`###${m[0]} -> ${m[1]}`);
        }
    };

    console.log(output.join('\n'));
}

autoCompany([
    'Audi | Q7 | 1000',
    'Audi | Q6 | 100',
    'BMW | X5 | 1000',
    'BMW | X6 | 100',
    'Citroen | C4 | 123',
    'Volga | GAZ-24 | 1000000',
    'Lada | Niva | 1000000',
    'Lada | Jigula | 1000000',
    'Citroen | C4 | 22',
    'Citroen | C5 | 10'
]);