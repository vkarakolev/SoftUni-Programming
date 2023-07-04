import { html, render } from "./node_modules/lit-html/lit-html.js";
import { get, post } from "./api.js"; 

const url = 'jsonstore/advanced/dropdown';
const container = document.getElementById('menu');
const form = document.querySelector('form');

window.onload = fillSellect;
form.addEventListener('submit', onSubmit);

async function onSubmit(e) {
    e.preventDefault();
   
    const text = document.getElementById('itemText').value;
    
    await post(url, {text : text});

    form.reset();
    fillSellect();
}

async function fillSellect() {
    const data = await get(url);

    const options = Object.values(data).map(e => createOption(e));
    render(options, container);
}

function createOption(item) {
    return html`<option value=${item._id}>${item.text}</option>`;
}