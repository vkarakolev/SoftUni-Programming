import { get, put } from './api.js';
import { showDetails } from './details.js';
import { createSubmitHandler } from './util.js';


async function getRecipeById(id) {
    return get('/data/recipes/' + id);
}

let main;
let section;
let setActiveNav;
let recipeId;

export function setupEdit(targetMain, targetSection, onActiveNav) {
    main = targetMain;
    section = targetSection;
    setActiveNav = onActiveNav;

    createSubmitHandler('edit-form', onEdit)

    async function onEdit(data) {
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

        const response = await put('/data/recipes/' + recipeId, body);
        showDetails(recipeId);
    }
}


export async function showEdit(id) {
    setActiveNav();
    main.innerHTML = '';
    main.appendChild(section);

    recipeId = id;
    const recipe = await getRecipeById(recipeId);

    section.querySelector('[name="name"]').value = recipe.name;
    section.querySelector('[name="img"]').value = recipe.img;
    section.querySelector('[name="ingredients"]').value = recipe.ingredients.join('\n');
    section.querySelector('[name="steps"]').value = recipe.steps.join('\n');
}