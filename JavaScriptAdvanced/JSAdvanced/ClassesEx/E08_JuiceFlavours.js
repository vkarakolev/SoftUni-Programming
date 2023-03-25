function juiceFlavours(arr) {
    let juiceMap = new Map();
    let bottlesMap = new Map();

    for(let e of arr) {
        let [key, value] = e.split(' => ');

        if(!juiceMap.has(key)) {
           juiceMap.set(key, Number(0));
        } 

        juiceMap.set(key, juiceMap.get(key) + Number(value));

        if(juiceMap.get(key) > 1000) {
            if(!bottlesMap.has(key)) {
                bottlesMap.set(key, Number(0));
            }

            let bottles = bottlesMap.get(key) + juiceMap.get(key) / 1000;
            bottlesMap.set(key, Math.floor(bottles))
            juiceMap.set(key, juiceMap.get(key) % 1000);
        }
    }

    for(let [key, value] of bottlesMap) {
        console.log(key + ' => ' + value);
    }
}

juiceFlavours([
    'Kiwi => 234',
    'Pear => 2345',
    'Watermelon => 3456',
    'Kiwi => 4567',
    'Pear => 5678',
    'Watermelon => 6789'
]);  

juiceFlavours([
    'Orange => 2000',
    'Peach => 1432',
    'Banana => 450',
    'Peach => 600',
    'Strawberry => 549'
]);