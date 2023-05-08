const form = document.querySelector('form');
form.addEventListener('submit', register);

async function register(e) {
    e.preventDefault();
    const formData = new FormData(e.target);
    const [email, password, rePass] = Object.entries(formData.entries);

    if (password !== rePass) {
        return console.error('Passwords don\'t match');
    }

    try {
        const response = await fetch('http://localhost:3030/users/register', {
            method: 'post',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                email: email,
                password: password
            })
        });

        const accessToken = await response.json();
        window.sessionStorage.setItem('accessToken', accessToken);
        window.location = '/';
    } catch (err) {
        console.error(err.message);
    }
}
