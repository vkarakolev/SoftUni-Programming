function deleteByEmail() {
    let input = document.getElementsByName('email')[0].value;
    let cells = document.querySelectorAll('#customers td:nth-child(2)');

    let found = false;
    for(let cell of cells) {
        if(cell.textContent === input) {
            cell.parentElement.remove();
            found = true;
        }
    }

    let result = document.getElementById('result');
    result.textContent = found ? 'Deleted.' : 'Not found.';       
}