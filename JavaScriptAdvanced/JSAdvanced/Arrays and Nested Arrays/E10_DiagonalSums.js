function diagonalSums(matrix) {
    let mainSum = 0;
    let secondarySum = 0;
    let mainIndex = 0;
    let secondaryIndex = matrix[1].length - 1;

    for(i = 0; i < matrix.length; i++) {
        mainSum += matrix[i][mainIndex];
        secondarySum += matrix[i][secondaryIndex];

        mainIndex++;
        secondaryIndex--;
    }

    console.log(`${mainSum} ${secondarySum}`);
}

diagonalSums([[20, 40],
              [10, 60]]);
              
diagonalSums([[3, 5, 17],
              [-1, 7, 14], 
              [1, -8, 89]]);