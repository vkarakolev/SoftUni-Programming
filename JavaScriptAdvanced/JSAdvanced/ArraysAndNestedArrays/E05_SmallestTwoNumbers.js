function smallestTwo(arr) {
    result = arr.sort((a, b) => a - b);
    console.log(result.slice(0, 2).join(' '));
}

smallestTwo([30, 15, 50, 5]);
smallestTwo([3, 0, 10, 4, 7, 3]);