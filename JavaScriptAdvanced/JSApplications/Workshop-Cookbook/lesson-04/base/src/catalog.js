import { setUserNav } from "./app.js";
import { showDetails } from "./details.js";
import { e } from "./dom.js";

async function getRecipes() {
    const response = await fetch('http://localhost:3030/data/recipes');
    const recipes = await response.json();

    return recipes;
}

function createRecipePreview(recipe) {
    const result = e('article', { className: 'preview', onClick: () => showDetails(recipe._id)},
        e('div', { className: 'title' }, e('h2', {}, recipe.name)),
        e('div', { className: 'small' }, e('img', { src: recipe.img })),
    );

    return result;
}

export async function setupCatalog() {
    const catalog = document.getElementById('catalog-view');

    const recipes = await getRecipes();
    const cards = recipes.map(createRecipePreview);

    catalog.innerHTML = '';
    const fragment = document.createDocumentFragment();
    cards.forEach(c => fragment.appendChild(c));
    catalog.appendChild(fragment);
}