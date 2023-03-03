function validate() {
    let inputField = document.querySelector('#email');
    inputField.addEventListener('change', validate);

    function validate() {
        let pattern = /^[a-z]+@[a-z]+\.[a-z]+$/;
        
        if(!inputField.value.match(pattern)) {
            inputField.classList.add('error');
            return;
        }

        inputField.classList.remove('error');
    }
}