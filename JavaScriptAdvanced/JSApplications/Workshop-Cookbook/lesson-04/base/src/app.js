import { setupCatalog } from "./catalog.js";
import { setupCreate } from "./create.js";
import { setupEdit } from "./edit.js";
import { setupLogin } from "./login.js";
import { setupRegister } from "./register.js";

window.addEventListener('load', () => {
    [...document.querySelectorAll('.nav')].map(e => e.addEventListener('click', onNavClick));
    document.getElementById('logout').addEventListener('click', logout);
    setUserNav();
    setupCatalog();
    setupRegister();
    setupLogin();
    setupEdit();
    setupCreate();
    
    showView('catalog-view');
});

function onNavClick(e) {
    const id = e.target.id;
    setActiveNav(id);
    showView(`${id}-view`);
}

function setActiveNav(id) {
    [...document.querySelectorAll('a')].forEach(a => a.id == id ? a.classList.add('active') : a.classList.remove('active'));
}

export function setUserNav() {
    document.getElementById('nav').style.display = 'inline-block';
    if (sessionStorage.getItem('authToken') != null) {
        document.getElementById('user').style.display = 'inline-block';
        document.getElementById('guest').style.display = 'none';
    } else {
        document.getElementById('guest').style.display = 'inline-block';
        document.getElementById('user').style.display = 'none';
    }
}

export function showView(id) {
    setUserNav();

    const navId = id.split('-')[0];
    setActiveNav(navId);

    [...document.querySelectorAll('section')].forEach(s => s.style.display = 'none');
    document.getElementById(`${id}`).style.display = 'block';
}

async function logout() {
    const token = sessionStorage.getItem('authToken');
    const response = await fetch('http://localhost:3030/users/logout', {
        method: 'get',
        headers: {
            'X-Authorization': token
        },
    });
    if (response.ok) {
        sessionStorage.removeItem('authToken');
        showView('catalog-view');
    } else {
        console.error('Error');
    }
}