import { post } from './api.js';
import { showHome } from './home.js';
import { createSubmitHandler, setUserData } from './util.js';


let main;
let section;
let setActiveNav;

export function setupLogin(targetMain, targetSection, onActiveNav) {
    main = targetMain;
    section = targetSection;
    setActiveNav = onActiveNav;
}

createSubmitHandler('login-form', onLogin);

async function onLogin(data) {
    const url = '/users/login';
    const body = {
        email: data.email,
        password: data.password
    };
    const userData = await post(url, body);

    setUserData(userData);
    showHome();
}

export function showLogin() {
    setActiveNav('loginLink');
    main.appendChild(section);
}