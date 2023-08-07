import { login } from "../api/user.js";
import { html } from "../lib.js";
import { createSubmitHandler } from "../util.js";

const loginTemplate = (onLogin) => html`
`;

export function showLogin(ctx) {
    ctx.render(loginTemplate(createSubmitHandler(onLogin)));

    async function onLogin(data) {
        await login(data);
        ctx.updateNav();
        ctx.page.redirect('/');
    }
}