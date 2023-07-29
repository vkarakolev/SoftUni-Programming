export function createSubmitHandler(formId, callback) {
    const form = document.getElementById(formId);
    form.addEventListener('submit', onSubmit);

    function onSubmit(event) {
        event.preventDefault();
        const formData = new FormData(event.target);
        const data = Object.fromEntries(formData);
        callback(data);
    }
}

export function setUserData(data) {
    sessionStorage.setItem('accessToken', data.accessToken);
    sessionStorage.setItem('userId', data._id);
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