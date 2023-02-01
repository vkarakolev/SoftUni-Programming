function calculator() {
    let selector1;
    let selector2;
    let resultSelector;

    let obj = {
        init: (num1, num2, result) => {
            selector1 = document.querySelector(num1);
            selector2 = document.querySelector(num2);
            resultSelector = document.querySelector(result);
        },
        add: () => {
            let firstNum = Number(selector1.value);
            let secondNum = Number(selector2.value);
            let result = firstNum + secondNum;
            resultSelector.value = result;
        },
        subtract: () => {
            let firstNum = Number(selector1.value);
            let secondNum = Number(selector2.value);
            let result = firstNum - secondNum;
            resultSelector.value = result;
        }
    }

    return obj;
}

const calculate = calculator ();
calculate.init ('#num1', '#num2', '#result');


