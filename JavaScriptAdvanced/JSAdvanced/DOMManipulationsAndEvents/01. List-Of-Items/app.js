function addItem() {
    let inputField = document.getElementById('newItemText');
    let input = inputField.value;

    let newItem = document.createElement('li');
    newItem.textContent = input;
    document.getElementById('items').appendChild(newItem);
    inputField.value = '';
}