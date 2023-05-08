async function getRecipes() {
    const response = await fetch('http://localhost:3030/jsonstore/cookbook/recipes');
    const recipes = await response.json();
    window.sessionStorage.setItem('recipes', JSON.stringify(recipes));
    
    createRecipe(recipes);
}

function createRecipe(recipes) {
    const mainElement = document.getElementsByTagName('main')[0];

    Object.values(recipes).forEach(r => {
        const recipe = document.createElement('article');
        recipe.classList.add('preview');
        recipe.innerHTML = `
            <div class="title">
                <h2>${r.name}</h2>
            </div>
            <div class="small">
                <img src="${r.img}">
            </div>`

        mainElement.appendChild(recipe);
        recipe.addEventListener('click', toggleInfo);
    });
}

async function toggleInfo(e) {
    const selected = e.target.classList.contains('preview') ? e.target : e.target.parentElement.parentElement;
    const title = selected.querySelector('h2').textContent;
    const recipes = Object.values(JSON.parse(window.sessionStorage.getItem('recipes')));
    const recipe = recipes.find(r => r.name == title);
    

    const url = 'http://localhost:3030/jsonstore/cookbook/details/';

    const response = await fetch(url + recipe._id);
    const data = await response.json();

    createDetailed(selected, data);  
}

function createDetailed(selected, data) {
    selected.classList.remove('preview');
    selected.removeEventListener('click', toggleInfo);

    selected.innerHTML = `
    <h2>${data.name}</h2>
    <div class="band">
        <div class="thumb">
            <img src="${data.img}">
        </div>
        <div class="ingredients">
            <h3>Ingredients:</h3>
            <ul></ul>
        </div>
    </div>
    <div class="description">
        <h3>Preparation:</h3>
    </div>`;

    const ul = selected.getElementsByTagName('ul')[0];

    data.ingredients.forEach(i => {
        const li = document.createElement('li');
        li.textContent = i;
        ul.appendChild(li);
    });

    const description = selected.getElementsByClassName('description')[0];

    data.steps.forEach(s => {
        const p = document.createElement('p');
        p.textContent = s;
        description.appendChild(p);
    });
}

getRecipes();