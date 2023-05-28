import { showView } from "./app.js";
import { getRecipeById, showDetails } from "./details.js";

let recipeId;

export function setupEdit() {
    const form = document.getElementById('edit-form');

    form.addEventListener('submit', (ev => {
        ev.preventDefault();
        const formData = new FormData(ev.target);
        onSubmit([...formData.entries()].reduce((p, [k, v]) => Object.assign(p, { [k]: v }), {}));
    }));
}

async function onSubmit(data) {
    const url = `http://localhost:3030/data/recipes/${recipeId}`;

    const body = {
        name: data.name,
        img: data.img,
        ingredients: data.ingredients.split('\n'),
        steps: data.steps.split('\n')
    };

    const token = sessionStorage.getItem('authToken');
    if (token == null) {
        return alert('You\'re not logged in!');
    };

    try {
        const response = await fetch(url, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
                'X-Authorization': token
            },
            body: JSON.stringify(body)
        });

        if(response.status == 200) {
            showDetails(recipeId);
        } else {
            const error = await response.json();
            throw new Error(error.message);
        }
    } catch (err) {
        alert(err.message);
    }
}

export async function showEdit(id) {
    recipeId = id;
    const section = document.getElementById('edit-view')
    const recipe = await getRecipeById(recipeId);

    section.querySelector('[name="name"]').value = recipe.name;
    section.querySelector('[name="img"]').value = recipe.img;
    section.querySelector('[name="ingredients"]').value = recipe.ingredients.join('\n');
    section.querySelector('[name="steps"]').value = recipe.steps.join('\n');

    showView(section.id);
}