import { deleteMotorcycle, getById } from "../api/data.js";
import { html, nothing } from "../lib.js"

const detailsTemplate = (motorcycle, isOwner, onDelete) => html`
<section id="details">
    <div id="details-wrapper">
        <img id="details-img" src="${motorcycle.imageUrl}" alt="example1" />
        <p id="details-title">${motorcycle.model}</p>
        <div id="info-wrapper">
            <div id="details-description">
                <p class="year">Year: ${motorcycle.year}</p>
                <p class="mileage">Mileage: ${motorcycle.mileage} km.</p>
                <p class="contact">Contact Number: ${motorcycle.contact}</p>
                <p id="motorcycle-description">${motorcycle.about}</p>
            </div>
            ${isOwner ? html`
            <div id="action-buttons">
                <a href="/edit/${motorcycle._id}" id="edit-btn">Edit</a>
                <a @click=${onDelete} href="javascript:void(0)" id="delete-btn">Delete</a>
            </div>`
        : nothing}
            
        </div>
    </div>
</section>`;

export async function showDetails(ctx) {
    const id = ctx.params.id;
    const motorcycle = await getById(id);

    const user = JSON.parse(sessionStorage.getItem('userData'));
    const isOwner = user && motorcycle._ownerId == user._id;

    ctx.render(detailsTemplate(motorcycle, isOwner, onDelete));

    async function onDelete() {
        const choice = confirm(`Are you sure you want to delete ${motorcycle.model}?`);

        if (choice) {
            await deleteMotorcycle(id);
            ctx.page.redirect('/catalog');
        };
    };
}