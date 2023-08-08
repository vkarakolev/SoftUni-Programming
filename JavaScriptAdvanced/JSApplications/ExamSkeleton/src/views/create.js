import { create } from "../api/data.js";
import { html } from "../lib.js"
import { createSubmitHandler } from "../util.js";

const createTemplate = (onCreate) => html`
<section id="create">
    <h2>Add Motorcycle</h2>
    <div class="form">
        <h2>Add Motorcycle</h2>
        <form @submit=${onCreate} class="create-form">
            <input type="text" name="model" id="model" placeholder="Model" />
            <input type="text" name="imageUrl" id="moto-image" placeholder="Moto Image" />
            <input type="number" name="year" id="year" placeholder="Year" />
            <input type="number" name="mileage" id="mileage" placeholder="mileage" />
            <input type="text" name="contact" id="contact" placeholder="contact" />
            <textarea id="about" name="about" placeholder="about" rows="10" cols="50"></textarea>
            <button type="submit">Add Motorcycle</button>
        </form>
    </div>
</section>`;

export async function showCreate(ctx) {
    ctx.render(createTemplate(createSubmitHandler(onCreate)));

    async function onCreate(data) {
        if(Object.values(data).some(e => e == '')) {
            return alert('All fields are required!');
        };

        await create(data);
        ctx.page.redirect('/catalog');
    };
}