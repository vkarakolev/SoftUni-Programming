function heroes(input) {
    let heroArray = [];

    for (let i of input) {
        let [name, level, items] = i.split(' / ');
        level = Number(level);
        items  = items ? items.split(', ') : [];

        heroArray.push({name, level, items});
    }

    let result = JSON.stringify(heroArray);
    console.log(result); 
}

heroes([
    'Isacc / 25 / Apple, GravityGun',
    'Derek / 12 / BarrelVest, DestructionSword',
    'Hes / 1 / Desolator, Sentinel, Antara'
]);

heroes(['Jake / 1000 / Gauss, HolidayGrenade']);