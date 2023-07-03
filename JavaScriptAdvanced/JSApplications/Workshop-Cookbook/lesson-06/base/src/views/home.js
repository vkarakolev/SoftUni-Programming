import { getRecent } from '../api/data.js';
import { html, render } from '../node_modules/lit-html/lit-html.js';

const homeTemplate = (recipes) => html`
    <section id="home">
        <div class="hero">
            <h2>Welcome to My Cookbook</h2>
        </div>
        <header class="section-title">Recently added recipes</header>
        <div class="recent-recipes">
            ${recipes.map(r = function () {
                let res = createRecipePreview(r);
                res += createSpacer();
                return res;
            })};
        </div>
        <footer class="section-title">
            <p>Browse all recipes in the <a href="/catalog">Catalog</a></p>
        </footer>
    </section>`;


export async function showHome(main) {
    container.innerHTML = 'Loading&hellip;';

    const recipes = await getRecent();
    return homeTemplate(recipes);
}

function createRecipePreview(recipe) {
    const result = (recipe) => html`
            <article class='recent' @click=${nav.goto('details', recipe._id)}>
                <div class='recent-preview'>
                    <img src='${recipe.img}'>
                </div>
                <div class='recent-title'>${recipe.name}</div>
            </article>`;

    return result;
}

function createSpacer() {
    return () => html`<div class='recent-space'></div>`;
}
