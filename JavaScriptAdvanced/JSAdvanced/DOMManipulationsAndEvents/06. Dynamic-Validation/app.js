function validate() {
    let textField = document.getElementById('email');
    let pattern = new RegExp('^[a-z]+\@[a-z]+\.[a-z]+$');

    debugger;
    textField.addEventListener('change', function(event){
        let input = textField.value;
        if(pattern.test(input)) {
            event.target.classList.remove('error');
        } else {
            event.target.classList.add('error');
        }
    });
}