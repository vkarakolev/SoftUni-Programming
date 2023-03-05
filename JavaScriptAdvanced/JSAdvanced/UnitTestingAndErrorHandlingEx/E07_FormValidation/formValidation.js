function validate() {
    let submit = document.getElementById('submit');
    submit.addEventListener('click', validateFields);
    let valid = document.getElementById('valid');
    let company = document.getElementById('company');
    company.addEventListener('change', function() {
        let companyInfo = document.getElementById('companyInfo');
        if(company.checked) {
            companyInfo.style.display = 'block';
        } else {
            companyInfo.style.display = 'none';
        }
    });
    
    
    function validateFields(e) {
        e.preventDefault();
        let fieldArray = Array.from(document.getElementsByTagName('input')).slice(0, 4);
 
        let username = document.getElementById('username');
        let userNamePattern = /^[a-zA-Z0-9]{3,20}$/;
        isValid(username, userNamePattern);
        
        let email = document.getElementById('email');
        let emailPattern = /.*@.*\..*/;
        isValid(email, emailPattern);

        let password = document.getElementById('password');
        let passwordPattern = /\w{5,15}/;
        isValid(password, passwordPattern);

        let confirmPass = document.getElementById('confirm-password');
        isValid(confirmPass, passwordPattern);
        
        if(password.value !== confirmPass.value) {
            password.setCustomValidity = 'false';
            confirmPass.setCustomValidity = 'false';
        }

        if(company.checked) {
            let companyNum = document.getElementById('companyNumber');
            fieldArray.push(companyNum);
            let companyPattern = /^[1-9]\d{3}$/;
            isValid(companyNum, companyPattern);
        } else {
            if(fieldArray.length > 4) {
                fieldArray.pop();
            }
        }

        let flag = true;
        for(let f of fieldArray) {
            if(f.setCustomValidity === 'true') {
                f.style.border = 'none';
            } else {
                f.style.borderStyle = 'solid';
                f.style.borderColor = 'red';
                flag = false;
            }
        }

        if(flag) {
            valid.style.display = 'block';
        } else {
            valid.style.display = 'none';
        }
    }

    function isValid(field, pattern) {
        if(field.value.match(pattern)) {
            field.setCustomValidity = 'true';
        } else {
            field.setCustomValidity = 'false';
        }
    }
}
