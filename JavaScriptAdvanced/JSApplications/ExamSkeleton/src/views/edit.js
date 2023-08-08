import { edit, getById } from "../api/data.js";
import { html } from "../lib.js"
import { createSubmitHandler } from "../util.js";

const editTemplate = (motorcycle, onEdit) => html`
<section id="edit">
    <h2>Edit Motorcycle</h2>
    <div class="form">
        <h2>Edit Motorcycle</h2>
        <form @submit=${onEdit} class="edit-form">
            <input type="text" name="model" id="model" placeholder="Model" .value="${motorcycle.model}"/>
            <input type="text" name="imageUrl" id="moto-image" placeholder="Moto Image" .value="${motorcycle.imageUrl}"/>
            <input type="number" name="year" id="year" placeholder="Year" .value="${motorcycle.year}"/>
            <input type="number" name="mileage" id="mileage" placeholder="mileage" .value="${motorcycle.mileage}"/>
            <input type="number" name="contact" id="contact" .value="${motorcycle.contact}"/>
            <textarea id="about" name="about" placeholder="about" rows="10" cols="50" .value="${motorcycle.about}"></textarea>
            <button type="submit">Edit Motorcycle</button>
        </form>
    </div>
</section>`;

export async function showEdit(ctx) {
    const id = ctx.params.id;
    const motorcycle = await getById(id);

    ctx.render(editTemplate(motorcycle, createSubmitHandler(onEdit)));

    async function onEdit(data) {
        if(Object.values(data).some(e => e == '')) {
            return alert('All fields are required!');
        };

        await edit(id, data);
        ctx.page.redirect(`/catalog/${id}`);
    };
}