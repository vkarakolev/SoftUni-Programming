function solve(num) {
    let result = '';
    for (let row = 1; row <= num; row++) {
        for(let col = 1; col <= num; col++) {
            result = result + '* ';
        }
        result = result + '\n';
    }

    console.log(result);
}

solve(1);
solve(2);
solve(5);
solve(7);