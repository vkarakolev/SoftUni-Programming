import { login } from "../data/auth.js";
import { post } from "../data/api.js";
import { html } from "../lib.js";
import { createSubmitHandler, setUserData } from "../util.js";

const loginTemplate = (onLogin) => html`
<div class="row space-top">
    <div class="col-md-12">
        <h1>Login User</h1>
        <p>Please fill all fields.</p>
    </div>
</div>
<form @submit=${onLogin}>
    <div class="row space-top">
        <div class="col-md-4">
            <div class="form-group">
                <label class="form-control-label" for="email">Email</label>
                <input class="form-control" id="email" type="text" name="email">
            </div>
            <div class="form-group">
                <label class="form-control-label" for="password">Password</label>
                <input class="form-control" id="password" type="password" name="password">
            </div>
            <input type="submit" class="btn btn-primary" value="Login" />
        </div>
    </div>
</form>`;

let context;

export function showLogin(ctx, next) {
    ctx.render(loginTemplate(createSubmitHandler(onLogin)));
    ctx.checkUserNav();
    context = ctx;
}

async function onLogin(data, form) {
    await login(data);
    context.page.redirect('/dashboard');
}