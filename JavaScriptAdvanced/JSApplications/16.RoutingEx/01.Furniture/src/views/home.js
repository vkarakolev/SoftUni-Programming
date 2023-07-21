import { getAll } from "../data/furniture.js";
import { html, repeat } from "../lib.js";

const homeTemplate = (furniture) => html`
<div class="row space-top">
    <div class="col-md-12">
        <h1>Welcome to Furniture System</h1>
        <p>Select furniture from the catalog to view details.</p>
    </div>
</div>
<div id='furnitureRow' class="row space-top">
    ${repeat(furniture, f => createFurnitureTemplate(f))}
</div>`;

export async function showHome(ctx, next) {
    const furniture = await getAll();
    ctx.render(homeTemplate(furniture));
}

function createFurnitureTemplate(data) {
    return html`
    <div class="col-md-4">
        <div class="card text-white bg-primary">
            <div class="card-body">
                    <img src="${data.img}" />
                    <p>${data.description}</p>
                    <footer>
                        <p>Price: <span>${data.price}</span></p>
                    </footer>
                    <div>
                        <a href= ${`/catalog/${data._id}`} class="btn btn-info">Details</a>
                    </div>
            </div>
        </div>
    </div>`;
}