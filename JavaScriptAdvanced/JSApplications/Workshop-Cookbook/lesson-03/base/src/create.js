const formElement = document.getElementById('create-form');
formElement.addEventListener('submit', createHendler);

function createHendler(e) {
    e.preventDefault();
    const formData = new FormData(e.target);
    let { img, ingredients, name, steps } = Object.fromEntries(formData);
    ingredients = ingredients.split('\n');
    steps = steps.split('\n');
    
    onCreate(name, img, ingredients, steps);
}

async function onCreate(name, img, ingredients, steps) {
    const url = 'http://localhost:3030/data/recipes';
    const body = { name, img, ingredients, steps };
    const token = sessionStorage.getItem('authToken');

    const response = await fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'X-Authorization': token
        },
        body: JSON.stringify(body)
    });
    const data = await response.json();
    
    if(response.status !== 200) {
        console.error(error);
    } else {
        window.location = './index.html';
    }
}