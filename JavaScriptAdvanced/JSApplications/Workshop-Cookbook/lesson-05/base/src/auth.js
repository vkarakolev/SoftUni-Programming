import { get } from "./api.js";
import { clearUserData } from "./util.js";

export function setUserNav() {
    if (sessionStorage.getItem('authToken') != null) {
        document.getElementById('user').style.display = 'inline-block';
        document.getElementById('guest').style.display = 'none';
    } else {
        document.getElementById('user').style.display = 'none';
        document.getElementById('guest').style.display = 'inline-block';
    }
}

export async function logout() {
    const response = await get('/users/logout');
    
    if (response.ok) {
        clearUserData();
        setUserNav();
        showCatalog();
    } else {
        console.error(await response.json());
    }
}