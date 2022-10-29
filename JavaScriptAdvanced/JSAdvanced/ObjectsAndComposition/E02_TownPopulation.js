function solve(input) {
    return input
        .map(e => {
            let data = e.split(' <-> ');
        
            return {
                name: data[0],
                population: Number(data[1])
            };
        })
        .reduce((result, town) => {
            if(result[town.name] === undefined) {
                result[town.name] = town.population;
            } else {
                result[town.name] += town.population;
            }

            return result;
        }, {});
}

console.log(solve([
    'Istanbul <-> 100000',
    'Honk Kong <-> 2100004',
    'Jerusalem <-> 2352344',
    'Mexico City <-> 23401925',
    'Istanbul <-> 1000'
]));