import { html, nothing, render } from "./node_modules/lit-html/lit-html.js";
import { contacts as data } from './contacts.js';

const contacts = data.map(c => Object.assign({}, c, { active: false }));

const root = document.getElementById('contacts');

let contactCard = (c, onToggle) => html`
<div class="contact card">
    <div>
        <i class="far fa-user-circle gravatar"></i>
    </div>
    <div class="info">
        <h2>Name: ${c.name}</h2>
        <button class="detailsBtn" @click=${onToggle.bind(null, c)}>Details</button>
        ${c.active
        ? html`
            <div class="details" id=${c.id}>
                <p>Phone number: ${c.phoneNumber}</p>
                <p>Email: ${c.email}</p>
            </div>`
        : nothing}
    </div>
</div>`;

update()

function update() {
    render(contacts.map(c => contactCard(c, onToggle)), root);
}

function onToggle(c) {
    c.active = !c.active;
    update();
}