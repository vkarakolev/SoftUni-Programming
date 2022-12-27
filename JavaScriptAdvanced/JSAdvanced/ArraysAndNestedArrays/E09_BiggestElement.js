function biggestElement(matrix) {
    let biggest = Number.MIN_SAFE_INTEGER;

    for(i = 0; i < matrix.length; i++) {
        matrix[i].forEach(element => {
            if(element > biggest) {
                biggest = element;
            }
        });
    }

    console.log(biggest);
}

biggestElement([[20, 50, 10],
                [8, 33, 145]]);
biggestElement([[3, 5, 7, 12], 
                [-1, 4, 33, 2], 
                [8, 3, 0, 4]]);