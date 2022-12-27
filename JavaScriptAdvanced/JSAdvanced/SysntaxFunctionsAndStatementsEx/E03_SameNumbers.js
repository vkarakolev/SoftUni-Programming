function sameNumbers(number) {
        let numberAsString = String(number);
        let sum = 0;

        for(i = 0; i < numberAsString.length; i++) {
            sum += Number(numberAsString.charAt(i));    
        }

        console.log(sum / numberAsString.length === Number(numberAsString.charAt(1)));
        console.log(sum);
}

sameNumbers(2222222);
sameNumbers(1234);