function solution(num) {
    let number = num;
    
    return function(n) {
        return number + n;
    }
}