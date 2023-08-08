import { searchByModel } from "../api/data.js";
import { html, nothing, repeat } from "../lib.js";
import { createSubmitHandler } from "../util.js";

let motorcycles = null;

const searchTemplate = (motorcycles, onSearch) => html`
<section id="search">
    <div class="form">
        <h4>Search</h4>
        <form @submit=${onSearch} class="search-form">
            <input type="text" name="search" id="search-input" />
            <button class="button-list">Search</button>
        </form>
    </div>
    <h4 id="result-heading">Results:</h4>
    <div class="search-result">
        ${motorcycles == null
        ? nothing
        : motorcycles.length == 0
            ? html`<h2 class="no-avaliable">No result.</h2>`
            : repeat(motorcycles, m => motorcycleTemplate(m))}
    </div>
</section>`;

let context;

export async function showSearch(ctx) {
    ctx.render(searchTemplate(motorcycles, createSubmitHandler(onSearch)));
    context = ctx;
}

async function onSearch(data) {
    if(data.search == '') {
        return alert('The search field is required!');
    };

    motorcycles = await searchByModel(data.search);
    context.render(searchTemplate(motorcycles, createSubmitHandler(onSearch)));
};

const motorcycleTemplate = (motorcycle) => html`
<div class="motorcycle">
    <img src="${motorcycle.imageUrl}" alt="example1" />
    <h3 class="model">${motorcycle.model}</h3>
    <a class="details-btn" href="/catalog/" + ${motorcycle._id}>More Info</a>
</div>`;