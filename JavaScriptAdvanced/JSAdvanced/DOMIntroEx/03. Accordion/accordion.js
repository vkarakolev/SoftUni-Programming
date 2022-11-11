function toggle() {
    let command = document.getElementsByClassName('button')[0];

    debugger;

    if(command.textContent === 'More') {
        document.getElementById('extra').style.display = 'block';
        command.textContent = 'Less';
    } else {
        document.getElementById('extra').style.display = 'none';
        command.textContent = 'More';
    }
}