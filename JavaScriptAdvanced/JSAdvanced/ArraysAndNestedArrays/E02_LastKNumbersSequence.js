function lastKNums(n, k) {
    let arr = [1];

    for (let i = 1; i < n; i++) {
        let startIndex = Math.max(0, i - k);
        let currentElement = arr.slice(startIndex, startIndex + k).reduce((a, b) => a + b);
        arr.push(currentElement);      
    }

    console.log(arr);
}

lastKNums(6, 3);
lastKNums(8, 2);