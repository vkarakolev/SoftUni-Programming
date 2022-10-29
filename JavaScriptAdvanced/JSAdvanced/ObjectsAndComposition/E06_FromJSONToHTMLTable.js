function converter(input) {
    let objArray = JSON.parse(input);

    let result = `\<table\>\n`;
    result += `\t\<tr\>`;

    let keys = Object.keys(objArray[0]);
    for(let i = 0; i < keys.length; i++) {
        result += `\<th\>`;
        result += keys[i];
        result += `\<\/th\>`;
    }

    result += `\<\/tr\>\n`;

    for(let i = 0; i < objArray.length; i++) {
        result += `\t\<tr\>`;

        let values = Object.values(objArray[i]);
        for(let k = 0; k < values.length; k++) {
            result += `\<td\>`;
            result += values[k];
            result += `\<\/td\>`;
        }

        result += `\<\/tr\>\n`;
    }

    result += `\<\/table\>`

    console.log(result);
}

converter(
    `[
        {"Name":"Stamat",
        "Score":5.5},
        {"Name":"Rumen",
        "Score":6}
    ]`
);

converter(
    `[
        {"Name":"Pesho",
        "Score":4,
        " Grade":8},
        {"Name":"Gosho",
        "Score":5,
        " Grade":8},
        {"Name":"Angel",
        "Score":5.50,
        "Grade":10}
    ]`
);