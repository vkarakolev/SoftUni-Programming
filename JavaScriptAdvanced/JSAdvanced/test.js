function solve(){
    result = 0;
    for(let i = 1; i <= 100; i++) {
        result += i;
        console.log(`${i}. ${result}`);
    }

    console.log(result);
}

solve();