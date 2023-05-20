const formElement = document.querySelector('#loginForm');
formElement.addEventListener('submit', loginHandler);

function loginHandler(e) {
    e.preventDefault();
    const formData = new FormData(e.target);
    const {email, password} = Object.fromEntries(formData);

    onLogin(email, password);
}

async function onLogin(email, password) {
    const url = 'http://localhost:3030/users/login';
    const body = {
        email, 
        password
    };

    const header = getHeaders('POST', body);
    const response = await fetch(url, header);
    const data = await response.json();

    if(response.status !== 200) {
        formElement.reset();
        return;
    }

    sessionStorage.setItem('authToken', data.accessToken);
    window.location = './index.html';
}

function getHeaders(method, body) {
    const token = localStorage.getItem('authToken');
    return {
        method: method,
        headers: {
            'Content-Type': 'application/json',
            'X-Authorization': token
        },
        body: JSON.stringify(body)
    };
}

