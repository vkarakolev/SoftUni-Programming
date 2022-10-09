function negativePosititve(arr) {
    let result = [];

    arr.forEach(e => {
        if(e < 0) {
            result.unshift(e);
        } else {
            result.push(e);
        }
    });

    console.log(result.join('\n'));
}

negativePosititve([7, -2, 8, 9]);
negativePosititve([3, -2, 0, -1]);