import { html, render } from '../lib.js';
import { clearUserData, setUserData } from '../util.js';
import { post } from './api.js';

const endpoints = {
    'login': '/users/login',
    'register': '/users/register',
    'logout': '/users/logout'
};

const userTemplate = html`
    <a href="/my-teams" class="action">My Teams</a>
    <a href="/logout" class="action">Logout</a>`;

const guestTemplate = html`
    <a href="/login" class="action">Login</a>
    <a href="/register" class="action">Register</a>`;

export function checkUserNav() {
    const nav = document.querySelector('nav');
    
    sessionStorage.getItem('accessToken') !== null
    ? render(userTemplate, nav)
    : render(guestTemplate, nav);
}

export async function login({email, password}) {
    const userData = await post(endpoints.login, {email, password});
    setUserData(userData);
    
    return userData;
}

export async function register({email, username, password}) {
    const userData = await post(endpoints.register, {email, username, password});
    setUserData(userData);
    
    return userData;
}

export async function logout() {
    await get(endpoints.logout);
    clearUserData();
}