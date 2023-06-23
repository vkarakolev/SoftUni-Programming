export function setUserData(data) {
    sessionStorage.setItem('authToken', data.accessToken);
    sessionStorage.setItem('userId', data._id);
}

export function clearUserData() {
    sessionStorage.removeItem('authToken');
    sessionStorage.removeItem('userId');
}