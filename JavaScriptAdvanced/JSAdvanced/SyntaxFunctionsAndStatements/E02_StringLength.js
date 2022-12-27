function solve(text1, text2, text3) {
    let lengthSum = text1.length + text2.length + text3.length;
    let avgLength = Math.floor(lengthSum / 3);
    console.log(lengthSum);
    console.log(avgLength);
}

solve('chocolate', 'ice cream', 'cake');
solve('pasta', '5', '22.3');