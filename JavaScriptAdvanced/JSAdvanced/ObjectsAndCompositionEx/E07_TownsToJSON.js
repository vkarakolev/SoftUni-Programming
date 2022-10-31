function converter(input) {
    let result = [];

    for (let i = 1; i < input.length; i++) {
        let data = input[i].slice(2, input[i].length - 2);
        let [Town, Latitude, Longitude] = data.split(' | ');
        Latitude = Number(Number(Latitude).toFixed(2));
        Longitude = Number(Number(Longitude).toFixed(2));
         
        result.push({Town, Latitude, Longitude});
    }

    console.log(JSON.stringify(result));

}

converter([
    '| Town | Latitude | Longitude |',
    '| Sofia | 42.696552 | 23.32601 |',
    '| Beijing | 39.913818 | 116.363625 |'
]);