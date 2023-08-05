export function createSubmitHandler(callback) {
    return function (event) {
        event.preventDefault();
        const formData = new FormData(event.target);
        const data = Object.fromEntries(formData);

        callback(data, event.target);
    }
}

export function setUserData(data) {
    sessionStorage.setItem('accessToken', data.accessToken);
    sessionStorage.setItem('userId', data._id);
}

export function getUserData() {
    if(sessionStorage.getItem('accessToken') == null) {
        return null;
    } else {
        return {
            accessToken: sessionStorage.getItem('accessToken'),
            id: sessionStorage.getItem('userId')
        };
    }
}

export function clearUserData() {
    sessionStorage.removeItem('accessToken');
    sessionStorage.removeItem('userId');
}

export function validateFields(data) {
    let flag = true;

    validate(data.make.length >= 4, 'new-make');
    validate(data.model.length >= 4, 'new-model');
    validate(data.year >= 1950 && data.year <= 2050, 'new-year');
    validate(data.description.length > 10, 'new-description');
    validate(data.price >= 0, 'new-price');
    validate(typeof(data.img) == 'string' && data.img, 'new-image');

    function validate(predicate, elementId) {
        const element = document.getElementById(elementId);
        element.class = 'form-control';
        
        if(predicate) {
            element.classList.add('is-valid');    
        } else {
            element.classList.add('is-invalid');
            flag = false;
        };
    };

    return flag;
}