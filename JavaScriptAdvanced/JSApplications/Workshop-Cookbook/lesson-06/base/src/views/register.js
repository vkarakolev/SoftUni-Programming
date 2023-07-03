import { html } from '../node_modules/lit-html/lit-html.js';
import { regster } from '../api/data.js';

const registerTemplate = () => html`
    <section id="register">
        <article>
            <h2>Register</h2>
            <form>
                <label>E-mail: <input type="text" name="email"></label>
                <label>Password: <input type="password" name="password"></label>
                <label>Repeat: <input type="password" name="rePass"></label>
                <input type="submit" value="Register">
            </form>
        </article>
    </section>`

export function setupRegister(section, nav) {
    const form = section.querySelector('form');

    form.addEventListener('submit', (ev => {
        ev.preventDefault();
        const formData = new FormData(ev.target);
        onSubmit([...formData.entries()].reduce((p, [k, v]) => Object.assign(p, { [k]: v }), {}));
    }));

    return showRegister;

    async function onSubmit(data) {
        if (data.password != data.rePass) {
            return alert('Passwords don\'t match');
        }

        try {
            await regster(data.email, data.password);
            nav.setUserNav();
            nav.goTo('catalog');
        } catch (err) {
            alert(err.message);
        }
    }
}

export function showRegister() {
    return registerTemplate();
}