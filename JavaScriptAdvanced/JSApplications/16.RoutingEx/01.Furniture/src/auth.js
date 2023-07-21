import { html, render } from "./lib.js";

const nav = document.querySelector('nav');
const guestTemplate = html`
<div id="guest">
    <a href="/login">Login</a>
    <a href="/register">Register</a>
</div>`;

const userTemplate = html`
<div id="user">
    <a href="/create" >Create Furniture</a>
    <a href="/my-furniture" >My Publications</a>
    <a id="logoutBtn" href="javascript:void(0)">Logout</a>
</div>`;

export function checkUserNav() {
    if(sessionStorage.getItem('accessToken' !== null)) {
        render(userTemplate, nav);
    } else {
        render(guestTemplate, nav);
    }
}