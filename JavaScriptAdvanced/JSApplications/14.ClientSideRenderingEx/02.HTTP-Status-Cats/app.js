import { cats } from './catSeeder.js';
import { html, render } from './node_modules/lit-html/lit-html.js';

const container = document.getElementById('allCats');

const catCard = (c, onToggle) => html`
<li>
    <img src="${c.imageLocation}" width="250" height="250" alt="Card image cap">
    <div class="info">
        <button class="showBtn" @click=${onToggle}>Show status code</button>
        <div class="status" style="display: none" id="${c.id}">
            <h4>Status Code: ${c.statusCode}</h4>
            <p>${c.statusMessage}</p>
        </div>
    </div>
</li>`;

update();


function createCardsList(cats) {
    const ul = html`
    <ul>
        ${cats.map(c => catCard(c, onToggle))}
    </ul>`

    return ul;
}

function onToggle(e) {
    const button = e.target;
    const statusDiv = button.parentElement.children[1];

    if(statusDiv.style.display == 'none') {
        button.textContent = 'Hide status code';
        statusDiv.style.display = 'block';
    } else {
        button.textContent = 'Show status code';
        statusDiv.style.display = 'none';
    };

    update();
}

function update() {
    render(createCardsList(cats), container);
}