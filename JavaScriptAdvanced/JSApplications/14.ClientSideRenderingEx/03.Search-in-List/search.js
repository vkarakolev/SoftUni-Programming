import { html, render } from "./node_modules/lit-html/lit-html.js";
import { towns } from "./towns.js"

const townsDiv = document.getElementById('towns');
const input = document.getElementById('searchText');
const result = document.getElementById('result');
let matchCounter;

update();

document.querySelector('button').addEventListener('click', search);

function search() {
   matchCounter = 0;
   update();
   result.textContent = `${matchCounter} matches found`;
}

function update() {
   render(createTownsList(towns), townsDiv);
}

function createTownsList(towns) {
   const ul = html`
   <ul>
      ${towns.map(t => createLi(t))};
   </ul>`

   return ul;
}

function createLi(t) {
   if (input.value && t.match(`^${input.value}.*`)){
      matchCounter++;
      return html`<li class="active">${t}</li>`;
   }
   return html`<li>${t}</li>`;
}
