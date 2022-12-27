function sortNames(arr) {
    let result = arr.sort();

    for(i = 0; i < arr.length; i++) {
        console.log(`${i + 1}.${result[i]}`);
    }
}

sortNames(["John", "Bob", "Christina", "Ema"]);