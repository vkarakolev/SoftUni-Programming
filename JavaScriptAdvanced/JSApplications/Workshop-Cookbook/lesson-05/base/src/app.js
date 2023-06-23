import { setupCatalog, showCatalog } from './catalog.js';
import { setupCreate, showCreate } from './create.js';
import { setupLogin, showLogin } from './login.js';
import { setupRegister, showRegister } from './register.js';
import { setupDetails } from './details.js';
import { setupEdit } from './edit.js';
import { setupHome, showHome } from './home.js';
import { logout, setUserNav } from './auth.js';

const main = document.querySelector('main');
const nav = document.querySelector('nav');

const links = {
    'homeLink': showHome,
    'catalogLink': showCatalog,
    'createLink': showCreate,
    'loginLink': showLogin,
    'registerLink': showRegister,
    'logoutBtn': logout,
};

window.addEventListener('load', () => {
    setUserNav();

    setupHome(main, document.getElementById('home'), setActiveNav);
    setupCatalog(main, document.getElementById('catalog'), setActiveNav);
    setupCreate(main, document.getElementById('create'), setActiveNav);
    setupLogin(main, document.getElementById('login'), setActiveNav);
    setupRegister(main, document.getElementById('register'), setActiveNav);
    setupDetails(main, document.getElementById('details'), setActiveNav);
    setupEdit(main, document.getElementById('edit'), setActiveNav);
    document.getElementById('views').remove();

    
    setupNavigation();

    // Start application in catalog view
    showHome();
});

function setupNavigation() {
    nav.addEventListener('click', (ev) => {
        if (ev.target.tagName == 'A') {
            const handler = links[ev.target.id];
            if (handler) {
                ev.preventDefault();
                main.innerHTML = '';
                handler();
            }
        }
    });
}

function setActiveNav(targetId) {
    [...nav.querySelectorAll('a')].forEach(a => a.id == targetId ? a.classList.add('active') : a.classList.remove('active'));
}