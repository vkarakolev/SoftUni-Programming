function biggerHalf(arr) {
    let result = arr.sort((a, b) => a - b);
    console.log(result.slice(Math.floor(result.length / 2)))
}

biggerHalf([4, 7, 2, 5]);
biggerHalf([3, 19, 14, 7, 2, 19, 6]);