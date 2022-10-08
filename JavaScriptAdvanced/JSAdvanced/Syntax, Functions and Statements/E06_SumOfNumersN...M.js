function solve(n, m) {
    let num1 = n * 1;
    let num2 = m * 1;

    let result = 0;
    for (let i = num1; i <= num2; i++) {
        result += i;
    }

    console.log(result);
}

solve('1', '5');
solve('-8', '20');