import { put } from "../data/api.js";
import { getById } from "../data/furnitureData.js";
import { html } from "../lib.js";
import { createSubmitHandler, validateFields } from "../util.js";

const editTemplate = (details) => html`
<div class="row space-top">
    <div class="col-md-12">
        <h1>Edit Furniture</h1>
        <p>Please fill all fields.</p>
    </div>
</div>
<form id='edit-form'>
    <div class="row space-top">
        <div class="col-md-4">
            <div class="form-group">
                <label class="form-control-label" for="new-make">Make</label>
                <input class="form-control" id="new-make" type="text" name="make" .value=${details.make}>
            </div>
            <div class="form-group has-success">
                <label class="form-control-label" for="new-model">Model</label>
                <input class="form-control" id="new-model" type="text" name="model" .value=${details.model}>
            </div>
            <div class="form-group has-danger">
                <label class="form-control-label" for="new-year">Year</label>
                <input class="form-control" id="new-year" type="number" name="year" .value=${details.year}>
            </div>
            <div class="form-group">
                <label class="form-control-label" for="new-description">Description</label>
                <input class="form-control" id="new-description" type="text" name="description" .value=${details.description}>
            </div>
        </div>
        <div class="col-md-4">
            <div class="form-group">
                <label class="form-control-label" for="new-price">Price</label>
                <input class="form-control" id="new-price" type="number" name="price" .value=${details.price}>
            </div>
            <div class="form-group">
                <label class="form-control-label" for="new-image">Image</label>
                <input class="form-control" id="new-image" type="text" name="img" .value=${details.img}>
            </div>
            <div class="form-group">
                <label class="form-control-label" for="new-material">Material (optional)</label>
                <input class="form-control" id="new-material" type="text" name="material" .value=${details.material}>
            </div>
            <input type="submit" class="btn btn-info" value="Edit" />
        </div>
    </div>
</form>`;

let context;

export async function showEdit(ctx, next) {
    const details = await getById(ctx.params.id);
    ctx.render(editTemplate(details));
    createSubmitHandler('edit-form', onEdit);
    context = ctx;
}

async function onEdit(data) {
    const isValid = validateFields(data);

    if(!isValid) {
        return;
    };

    const id = context.params.id;
    const url = `/data/catalog/${id}`;
    const body = {
        make: data.make,
        model: data.model,
        year: data.year,
        description: data.description,
        price: data.price,
        img: data.img,
        material: data.material
    };

    const response = await put(url, body);
    context.page.redirect(`/catalog/${id}`);
}