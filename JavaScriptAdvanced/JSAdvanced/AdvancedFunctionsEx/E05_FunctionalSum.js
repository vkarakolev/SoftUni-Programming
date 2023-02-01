function add(num) {
    let sum = 0;

    return function(num) {
        return sum += num;
    }();

    console.log();
}

console.log(add(1).toString());