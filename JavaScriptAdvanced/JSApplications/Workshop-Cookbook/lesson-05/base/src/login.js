import { setUserNav } from './auth.js';
import { showHome } from './home.js';
import { setUserData } from './util.js';


let main;
let section;
let setActiveNav;

export function setupLogin(targetMain, targetSection, onActiveNav) {
    main = targetMain;
    section = targetSection;
    setActiveNav = onActiveNav;

    const form = targetSection.querySelector('form');

    form.addEventListener('submit', (ev => {
        ev.preventDefault();
        const formData = new FormData(ev.target);
        onSubmit([...formData.entries()].reduce((p, [k, v]) => Object.assign(p, { [k]: v }), {}));
    }));

    async function onSubmit(data) {
        const url = '/users/login';
        const body = {
            email: data.email,
            password: data.password
        };

        try {
            const userData = await post(url, body);

            setUserData(userData);
            setUserNav();
            showHome();
        } catch (err) {
            console.error(err.message);
        }
    }
}

export function showLogin() {
    setActiveNav('loginLink');
    main.appendChild(section);
}