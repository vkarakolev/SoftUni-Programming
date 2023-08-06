import { register } from '../data/auth.js';
import { html, nothing } from '../lib.js';
import { createSubmitHandler } from '../util.js';

const registerTemplate = (onRegister, error) => html`
<section id="register">
    <article class="narrow">
        <header class="pad-med">
            <h1>Register</h1>
        </header>
        <form @submit=${onRegister} id="register-form" class="main-form pad-large">
            ${error !== null ? html`<div style="display: none" class="error">${error}</div>` : nothing}
            <label>E-mail: <input type="text" name="email"></label>
            <label>Username: <input type="text" name="username"></label>
            <label>Password: <input type="password" name="password"></label>
            <label>Repeat: <input type="password" name="repass"></label>
            <input class="action cta" type="submit" value="Create Account">
        </form>
        <footer class="pad-small">Already have an account? <a href="/login" class="invert">Sign in here</a>
        </footer>
    </article>
</section>`;

let context;

export function showRegister(ctx) {
    ctx.render(registerTemplate(createSubmitHandler(onRegister, null)));
    ctx.checkUserNav();
    context = ctx;
}

async function onRegister(data, form) {
    try{
        isValid(data)
        await register(data);
    } catch(err) {
        context.render(registerTemplate(createSubmitHandler(onRegister, err.message)));
        return;
    }

    context.page.redirect('/my-teams');
}

function isValid({ email, username, password, repass}) {
    validate(!email, 'Email is required!');
    validate(username.length < 3, 'Username must be at least 3 characters!');
    validate(password.length < 3, 'Password must be at least 3 characters!');
    validate(password !== repass, 'Passwords don\'t match!');

    function validate(predicate, message) {
        if(predicate) {
            throw new Error(message);
        }
    }
}