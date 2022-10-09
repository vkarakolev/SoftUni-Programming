function extractIncreasing(arr) {
    let biggest = Number.MIN_SAFE_INTEGER;
    let result = [];

    arr.forEach(e => {
        if(e >= biggest) {
            result.push(e);
            biggest = e;
        }
    });

    // console.log(result);
    return result;
}

extractIncreasing([1, 2, 3, 4]);
extractIncreasing([20, 3, 2, 15, 6, 1]);
