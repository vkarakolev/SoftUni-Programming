import { get, post } from "./api.js";
import { html, page, render } from "../lib.js";
import { clearUserData, setUserData } from "../util.js";

const nav = document.querySelector('nav');
nav.addEventListener('click', setActiveNav);

const endpoints = {
    'login': '/users/login',
    'register': '/users/register',
    'logout': '/users/logout'
}

const guestTemplate = html`
<div id="guest">
    <a id='loginLink' href="/login">Login</a>
    <a id ='registerLink' href="/register">Register</a>
</div>`;

const userTemplate = html`
<div id="user">
    <a id='createLink' href="/create" >Create Furniture</a>
    <a id='profileLink' href="/my-furniture" >My Publications</a>
    <a @click=${onLogout} id="logoutBtn">Logout</a>
</div>`;

export function checkUserNav() {
    sessionStorage.getItem('accessToken') !== null
    ? render(userTemplate, nav)
    : render(guestTemplate, nav);
}

function setActiveNav(e) {
    // const links = nav.querySelector('a', 'div a');
    // links.forEach(a => {
    //     a.classList.remove('active');
    // });

    // if(typeof(e.target == 'A')) {
    //     e.target.classList.add('active');
    // };
}

export async function login({email, password}) {
    const userData = await post(endpoints.login, {email, password});
    setUserData(userData);

    return userData;
}

export async function register({email, password, rePass}) {
    if(password !== rePass) {
        return alert('Passwords don\'t match!');
    };

    const userData = await post(endpoints.register, {email, password});
    setUserData(userData);

    return userData;
}

export async function onLogout() {
    const response = await get(endpoints.logout);
    clearUserData();
    
    page.redirect('/');
}