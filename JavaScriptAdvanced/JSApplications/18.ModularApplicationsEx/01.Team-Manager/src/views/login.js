import { login } from '../data/auth.js';
import { html, nothing } from '../lib.js';
import { createSubmitHandler } from '../util.js';

const loginTemplate = (onLogin, error) => html`
<section id="login">
    <article class="narrow">
        <header class="pad-med">
            <h1>Login</h1>
        </header>
        <form @submit=${onLogin} id="login-form" class="main-form pad-large">
            ${error ? html`<div style="display: none" class="error">${error}</div>` : nothing}
            <label>E-mail: <input type="text" name="email"></label>
            <label>Password: <input type="password" name="password"></label>
            <input class="action cta" type="submit" value="Sign In">
        </form>
        <footer class="pad-small">Don't have an account? <a href="/register" class="invert">Sign up here</a>
        </footer>
    </article>
</section>`;

let context;

export function showLogin(ctx) {
    ctx.render(loginTemplate(createSubmitHandler(onLogin)));
    ctx.checkUserNav();
    context = ctx;
}

async function onLogin(data, form) {
    try{
        await login(data);
    } catch(err) {
        context.render(loginTemplate(createSubmitHandler(onLogin, err.message)));
    }
    context.page.redirect('/my-teams');
}