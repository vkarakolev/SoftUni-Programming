import { setUserNav } from './auth.js';
import { showHome } from './home.js';
import { setUserData } from './util.js';


let main;
let section;
let setActiveNav;

export function setupRegister(targetMain, targetSection, onActiveNav) {
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
        if (data.password != data.rePass) {
            return alert('Passwords don\'t match');
        }

        const url = '/users/register'
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


export function showRegister() {
    setActiveNav('registerLink');
    main.appendChild(section);
}