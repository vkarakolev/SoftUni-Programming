function addItem() {
    let input = document.getElementById('newItemText');
    let textToAdd = input.value;
    
    let ul = document.getElementById('items');
    let li = document.createElement('li');
    li.textContent = textToAdd;

    let remove = document.createElement('a');
    let linkText = document.createTextNode('[Delete]');
    remove.appendChild(linkText);
    remove.href = '#';
    remove.addEventListener('click', function(event){
        li.remove();
    });

    li.appendChild(remove);
    ul.appendChild(li);
    input.value = '';
}