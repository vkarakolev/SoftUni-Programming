import { post } from "../data/api.js";
import { html } from "../lib.js";
import { createSubmitHandler, setUserData } from "../util.js";

const registerTemplate = html`
<div class="row space-top">
    <div class="col-md-12">
        <h1>Register New User</h1>
        <p>Please fill all fields.</p>
    </div>
</div>
<form id='register-form'>
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
            <div class="form-group">
                <label class="form-control-label" for="rePass">Repeat</label>
                <input class="form-control" id="rePass" type="password" name="rePass">
            </div>
            <input type="submit" class="btn btn-primary" value="Register" />
        </div>
    </div>
</form>`;

let context;

export function showRegister(ctx, next) {
    ctx.render(registerTemplate);
    createSubmitHandler('register-form', onRegister);
    ctx.checkUserNav();
    context = ctx;
}

async function onRegister(data) {
    if(data.password !== data.rePass) {
        return alert('Passwords don\'t match!');
    };

    const url = '/users/register';
    const body = {
        email: data.email,
        password: data.password
    };

    const userData = await post(url, body);
    setUserData(userData);
    context.page.redirect('/dashboard');
}