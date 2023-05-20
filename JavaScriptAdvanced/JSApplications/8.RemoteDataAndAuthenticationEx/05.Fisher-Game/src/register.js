document.getElementById('register-form').addEventListener('submit', registerHandler);

function registerHandler(e) {
    e.preventDefault();
    const formData = new FormData(e.target);
    const {email, password, rePass } = Object.fromEntries(formData);

    if(password !== rePass) {

    }

    onRegister(email, password);
}

async function onRegister(email, password) {
    const url = 'http://localhost:3030/users/register';
    const body = {
        email,
        password
    };

    const header = getHeaders('POST', body);
    const response = await fetch(url, header);
    const data = await response.json();

    sessionStorage.setItem('userData', JSON.stringify({
        accessToken: data.accessToken,
        email: data.email,
        id: data._id
    }));

    debugger;
    return data;
}

function getHeaders(method, body) {
    return {
        method: method,
        headers: {
            "Content-Type": 'application/json'
        },
        body: JSON.stringify(body)
    };
}