async function getRecipes() {
    const response = await fetch('http://localhost:3030/jsonstore/cookbook/recipe');
    const recipes = await response.json();

    return Object.values(recipes);
}