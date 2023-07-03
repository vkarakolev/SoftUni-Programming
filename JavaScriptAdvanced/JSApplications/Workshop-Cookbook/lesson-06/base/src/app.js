import { createNav } from './navigation.js';
import { logout as apiLogout } from './api/data.js';

window.addEventListener('load', async () => {
    const main = document.querySelector('main');
    const navbar = document.querySelector('nav');
    const navigation = createNav(main, navbar);
    
    navigation.setUserNav();
    document.getElementById('logoutBtn').addEventListener('click', logout);

    // Start application in catalog view
    navigation.goTo('home');


    async function logout() {
        try {
            await apiLogout();
            navigation.updateNav();
            navigation.goTo('catalog');
        } catch (err) {
            alert(err.message);
        }
    }
});
