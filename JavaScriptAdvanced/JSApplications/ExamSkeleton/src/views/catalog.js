import { getAll } from "../api/data.js";
import { html } from "../lib.js"

const catalogTemplate = (motorcycles) => html`
<h2>Available Motorcycles</h2>
    <section id="dashboard">
        ${motorcycles.length == 0
        ? html`<h2 class="no-avaliable">No avaliable motorcycles yet.</h2>`
        : motorcycles.map(m => motorcycleTemplate(m))}
    </section>`;

export async function showCatalog(ctx) {
    const motorcycles = await getAll();

    ctx.render(catalogTemplate(motorcycles));
};

const motorcycleTemplate = (motorcycle) => html`
<div class="motorcycle">
    <img src="${motorcycle.imageUrl}" alt="example1" />
    <h3 class="model">${motorcycle.model}</h3>
    <p class="year">Year: ${motorcycle.year}</p>
    <p class="mileage">Mileage: ${motorcycle.mileage} km.</p>
    <p class="contact">Contact Number: ${motorcycle.contact}</p>
    <a class="details-btn" href="/catalog/${motorcycle._id}">More Info</a>
</div>`;
