import { get, post } from "./api.js"

const endpoint = {
    'login': 'users/login',
    'register': 'users/register',
    'logout': 'users/logout',
};

export async function login(email, password) {
    const user = await post(endpoint.login, {email, password});
    sessionStorage.setItem('user', JSON.stringify(user));
};

export async function regiseter(email, password) {
    const user = await post(endpoint.register, {email, password});
    sessionStorage.setItem('user', JSON.stringify(user));
};

export async function logout() {
    await get(endpoint.logout);
    sessionStorage.removeItem('user');
};