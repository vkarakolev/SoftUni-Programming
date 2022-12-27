function area() {
    return Math.abs(this.x * this.y);
}

function vol() {
    return Math.abs(this.x * this.y * this.z);
}

function solve(area, vol, input) {
    input = JSON.parse(input);

    let result = [];
    for(let i of input) {
        let calculatedArea = area.call(i);
        let calculatedVol = vol.call(i);

        result.push({
            area: calculatedArea,
            volume: calculatedVol
        })
    }

    return result;
}

let res = solve (area, vol, `[

    {"x":"1","y":"2","z":"10"},
    
    {"x":"7","y":"7","z":"10"},
    
    {"x":"5","y":"2","z":"10"}
    
    ]`);

console.log(JSON.stringify(res));