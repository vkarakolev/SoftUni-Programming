import { post } from "../data/api.js";
import { html } from "../lib.js";
import { createSubmitHandler, setUserData } from "../util.js";

const loginTemplate = html`
<div class="row space-top">
    <div class="col-md-12">
        <h1>Login User</h1>
        <p>Please fill all fields.</p>
    </div>
</div>
<form id='login-form'>
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
    ctx.render(loginTemplate);
    createSubmitHandler('login-form', onLogin);
    ctx.checkUserNav();
    context = ctx;
}

async function onLogin(data) {
    const url = '/users/login'
    const body = {
        email: data.email,
        password: data.password
    };

    const userData = await post(url, body);
    setUserData(userData);
    context.page.redirect('/dashboard');
}