const formElement = document.getElementById('register-form');
formElement.addEventListener('submit', registerHandler);

function registerHandler(e) {
    e.preventDefault();
    const formData = new FormData(e.target);
    const { email, password, rePass } = Object.fromEntries(formData);

    if (password !== rePass) {
        return console.error('Passwords don\'t match');
    } else {
        onRegister(email, password);
    }
}

async function onRegister(email, password) {
    const url = 'http://localhost:3030/users/register';
    const body = {
        email,
        password
    };

    try {
        const header = getHeaders('POST', body);
        const response = await fetch(url, header);
        const data = await response.json();
        
        if(response.status !== 200) {
            formElement.reset();
            return;
        }

        localStorage.setItem('authToken', data.accessToken);
        window.location = './index.html';
    } catch (e) {
        console.log(e.message);
    }
}

function getHeaders(method, body) {
    return {
        method: method,
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(body)
    };
}
