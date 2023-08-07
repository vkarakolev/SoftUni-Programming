import { register } from "../api/user.js";
import { html } from "../lib.js";
import { createSubmitHandler } from "../util.js";

const registerTemplate = (onRegister) => html`
`;

export function showRegister(ctx) {
    ctx.render(registerTemplate(createSubmitHandler(onRegister)));

    async function onRegister(data) {
        if(data.password !== data.repass) {
            return alert('Passwords don\'t match!');
        };

        await register(data);
        ctx.updateNav();
        ctx.page.redirect('/');
    }
}