export function getUserData() {
    if (sessionStorage.getItem('accessToken') == null) {
        return null;
    } else {
        return {
            'accessToken': sessionStorage.getItem('accessToken'),
            'id': sessionStorage.getItem('userId'),
        };
    };
}

export function setUserData(data) {
    sessionStorage.setItem('accessToken', data.accessToken);
    sessionStorage.setItem('userId', data.userId);
}

export function clearUserData() {
    sessionStorage.removeItem('accessToken');
    sessionStorage.removeItem('userId');
}

export function createSubmitHandler(callback) {
    return function(event) {
        event.preventDefault();
        const formData = new FormData(event.target);
        const data = Object.fromEntries(formData);

        callback(data, event.target);
    };
}