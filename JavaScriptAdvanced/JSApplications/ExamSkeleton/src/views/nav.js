import { logout } from "../api/user.js";
import { html, page, render } from "../lib.js";
import { getUserData } from "../util.js";

const header = document.querySelector('header');

const navTemplate = (hasUser) => html`
<a id="logo" href="/"><img id="logo-img" src="./images/logo.png" alt="" /></a>
<nav>
    <div>
        <a href="/catalog">Motorcycles</a>
        <a href="/search">Search</a>
    </div>
        ${!hasUser 
            ? html`
            <div class="guest">
                <a href="/login">Login</a>
                <a href="/register">Register</a>
            </div>`
            : html`
            <div class="user">
                <a href="/create">Add Motorcycle</a>
                <a @click=${onLogout} href="javascript:void(0)">Logout</a>
            </div>`}
</nav>`;

export function updateNav() {
    const user = getUserData();
    render(navTemplate(user), header);
}

function onLogout() {
    logout();
    updateNav();
    page.redirect('/');
}