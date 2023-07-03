import { html } from '../node_modules/lit-html/lit-html.js';
import { login } from '../api/data.js';

const loginTemplate = () => html`
    <section id="login">
        <article>
            <h2>Login</h2>
            <form>
                <label>E-mail: <input type="text" name="email"></label>
                <label>Password: <input type="password" name="password"></label>
                <input type="submit" value="Login">
            </form>
        </article>
    </section>`;

export function setupLogin(section, nav) {
    const form = section.querySelector('form');

    form.addEventListener('submit', (ev => {
        ev.preventDefault();
        const formData = new FormData(ev.target);
        onSubmit([...formData.entries()].reduce((p, [k, v]) => Object.assign(p, { [k]: v }), {}));
    }));

    return showLogin;

    async function onSubmit(data) {
        try {
            console.log('logging in');
            await login(data.email, data.password);
            nav.setUserNav();
            nav.goTo('catalog');
        } catch (err) {
            alert(err.message);
        }
    }
}

export function showLogin() {
    return loginTemplate();
}