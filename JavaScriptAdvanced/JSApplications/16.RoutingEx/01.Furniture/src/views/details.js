import { html } from "../lib.js";
import { getById } from "../data/furnitureData.js";
import { del } from "../data/api.js";

const detailsTemplate = (details) => html`
<div class="row space-top">
    <div class="col-md-12">
        <h1>Furniture Details</h1>
    </div>
</div>
<div class="row space-top">
    <div class="col-md-4">
        <div class="card text-white bg-primary">
            <div class="card-body">
                <img src="${"../" + details.img}" />
            </div>
        </div>
    </div>
    <div class="col-md-4">
        <p>Make: <span>${details.make}</span></p>
        <p>Model: <span>${details.model}</span></p>
        <p>Year: <span>${details.year}</span></p>
        <p>Description: <span>${details.description}</span></p>
        <p>Price: <span>${details.price + ' $'}</span></p>
        <p>Material: <span>${details.material}</span></p>
        <div style=${details._ownerId == sessionStorage.getItem('userId') ? 'display: block' : 'display: none'}>
            <a href=${`/edit/${details._id}`} class="btn btn-info">Edit</a>
            <a @click=${onDelete} href=/dashboard class="btn btn-red">Delete</a>
        </div>
    </div>
</div>`;

let furnitureDetails;

export async function showDetails(ctx, next) {
    furnitureDetails = await getById(ctx.params.id);
    ctx.render(detailsTemplate(furnitureDetails));
}

async function onDelete() {
    confirm(`Are you sure you want to delete ${furnitureDetails.make} - ${furnitureDetails.model}?`);

    const url = `/data/catalog/${furnitureDetails._id}`;
    const response = await del(url);
}