function processOdd(arr) {
    let result = [];

    for (let i = 1; i < arr.length; i += 2) {
        result.unshift(arr[i] * 2);
    }

    console.log(result.join(' '));
}

processOdd([10, 15, 20, 25]);
processOdd([3, 0, 10, 4, 7, 3]);