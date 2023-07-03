import { html, render } from './node_modules/lit-html/lit-html.js';

const root = document.getElementById('root');
const form = document.querySelector('form');
form.addEventListener('submit', onSubmit);

function onSubmit(e) {
    e.preventDefault();
    const formData = new FormData(e.target);
    const {towns} = Object.fromEntries(formData);
    const townsArr = towns.split(', ');
    renderTowns(townsArr); 
    form.reset();
}

function renderTowns(towns) {
    const result = createTownsList(towns);
    render(result, root);
}

function createTownsList(towns) {
    const result = html`
    <ul>
        ${towns.map(t => html`<li>${t}</li>`)};
    </ul>`;

    return result;
}


