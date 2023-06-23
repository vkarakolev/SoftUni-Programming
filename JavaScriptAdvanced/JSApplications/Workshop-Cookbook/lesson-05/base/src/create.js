import { post } from './api.js';
import { showDetails } from './details.js';
import { createSubmitHandler } from './util.js';


let main;
let section;
let setActiveNav;

export function setupCreate(targetMain, targetSection, onActiveNav) {
    main = targetMain;
    section = targetSection;
    setActiveNav = onActiveNav;
}

createSubmitHandler('create-form', onCreate);

async function onCreate(data) {
    const body = {
        name: data.name,
        img: data.img,
        ingredients: data.ingredients.split('\n').map(l => l.trim()).filter(l => l != ''),
        steps: data.steps.split('\n').map(l => l.trim()).filter(l => l != '')
    };

    const token = sessionStorage.getItem('accessToken');
    if (token == null) {
        return alert('You\'re not logged in!');
    }

    const response = await post('/data/recipes', body);
    showDetails(response._id);
}


export function showCreate() {
    setActiveNav('createLink');
    main.appendChild(section);
}