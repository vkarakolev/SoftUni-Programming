function addItem() {
    let inputText = document.querySelector('#newItemText');
    let inputValue = document.querySelector('#newItemValue');

    let option = document.createElement('option');
    option.textContent = inputText.value;
    option.value = inputValue.value;

    let menu = document.querySelector('#menu');
    menu.appendChild(option);

    inputText.value = '';
    inputValue.value = '';
}