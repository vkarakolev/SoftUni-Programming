import { post } from './api.js';
import { showHome } from './home.js';
import { createSubmitHandler, setUserData } from './util.js';


let main;
let section;
let setActiveNav;

export function setupRegister(targetMain, targetSection, onActiveNav) {
    main = targetMain;
    section = targetSection;
    setActiveNav = onActiveNav;
}

createSubmitHandler('register-form', onRegister)

async function onRegister(data) {
    if (data.password != data.rePass) {
        return alert('Passwords don\'t match');
    }

    const url = '/users/register'
    const body = {
        email: data.email,
        password: data.password
    };

    const userData = await post(url, body);

    setUserData(userData);
    showHome();
}


export function showRegister() {
    setActiveNav('registerLink');
    main.appendChild(section);
}