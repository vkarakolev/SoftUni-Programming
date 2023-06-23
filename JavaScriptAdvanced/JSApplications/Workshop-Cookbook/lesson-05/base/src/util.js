export function setUserData(data) {
    sessionStorage.setItem('accessToken', data.accessToken);
    sessionStorage.setItem('userId', data._id);
}

export function clearUserData() {
    sessionStorage.removeItem('accessToken');
    sessionStorage.removeItem('userId');
}

export function createSubmitHandler(formId, callback) {
    const form = document.getElementById(formId);
    form.addEventListener('submit', onSubmit);
    
    function onSubmit(event) {
        event.preventDefault();
        const formData = new FormData(event.target);
        const data = Object.fromEntries(formData);

        form.reset();
        callback(data, event);
    }
}