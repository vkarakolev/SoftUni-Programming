import { get } from "../data/api.js";
import { html, repeat } from "../lib.js";
import { createFurnitureTemplate } from "./home.js";

const myFurnitureTemplate = (furniture) => html`
<div class="row space-top">
    <div class="col-md-12">
        <h1>My Furniture</h1>
        <p>This is a list of your publications.</p>
    </div>
</div>
<div id="furniture-row" class="row space-top">
    ${repeat(furniture, f => createFurnitureTemplate(f))}
</div>`

export async function showMyFurniture(ctx, next) {
    const userId = sessionStorage.getItem('userId');
    const url = `/data/catalog?where=_ownerId%3D%22${userId}%22`;
    const furniture = await get(url);
    ctx.render(myFurnitureTemplate(furniture));
}