import { html } from "../lib.js";
import { getById } from "../data/furniture.js";

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
                <img src="${details.img}" />
            </div>
        </div>
    </div>
    <div class="col-md-4">
        <p>Make: <span>${details.make}</span></p>
        <p>Model: <span>${details.model}</span></p>
        <p>Year: <span>${details.year}</span></p>
        <p>Description: <span>${details.description}</span></p>
        <p>Price: <span>${details.price}</span></p>
        <p>Material: <span>${details.material}</span></p>
        <div>
            <a href=”#” class="btn btn-info">Edit</a>
            <a href=”#” class="btn btn-red">Delete</a>
        </div>
    </div>
</div>`;

// ${buttons = details._ownerId == sessionStorage.getItem('user').id ?
// `<div>
// <a href=”#” class="btn btn-info">Edit</a>
// <a href=”#” class="btn btn-red">Delete</a>
// </div>` : ''}

export async function showDetails(ctx, next) {
    const furnitureDetails = await getById(ctx.params.id);
    ctx.render(detailsTemplate(furnitureDetails));
}