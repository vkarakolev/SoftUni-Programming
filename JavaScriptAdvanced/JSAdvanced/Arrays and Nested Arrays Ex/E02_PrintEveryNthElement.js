function printEverNth(arr, step) {
    let result = [];

    for (let i = 0; i < arr.length; i += step) {
        result.push(arr[i]);
    }

    console.log(result);
}

printEverNth(['5', '20', '31', '4', '20'], 2);
printEverNth(['dsa', 'asd', 'test', 'tset'], 2);
printEverNth(['1', '2', '3', '4', '5'], 6);