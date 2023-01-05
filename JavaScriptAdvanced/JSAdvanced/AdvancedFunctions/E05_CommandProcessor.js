function solution() {
    let text = '';

    return {
        append: (s) => text += s,
        removeStart: (n) => text = text.substring(n),
        removeEnd: (n) => text = text.substring(0, text.length - n),
        print: () => console.log(text)
    }
}

let firstZeroTest = solution();
firstZeroTest.append('hello'); 
firstZeroTest.append('again'); 
firstZeroTest.removeStart(3); 
firstZeroTest.removeEnd(4); 
firstZeroTest.print();

let secondZeroTest = solution();
secondZeroTest.append('123');
secondZeroTest.append('45');
secondZeroTest.removeStart(2);
secondZeroTest.removeEnd(1);
secondZeroTest.print();