function solution() {
    window.addEventListener('load', attachArticles);
}

async function attachArticles() {
    const response = await fetch('http://localhost:3030/jsonstore/advanced/articles/list');
    const articles = await response.json();

    const main = document.getElementById('main')
    articles.forEach(a => {
        main.innerHTML += `
        <div class="accordion">
            <div class="head">
                <span>${a.title}</span>
                <button class="button" id="${a._id}">More</button>
            </div>
            <div class="extra">
                <p></p>
            </div>
        </div>`;
        
        let button = document.getElementById(a._id);
        button.addEventListener('click', toggleContent);
    });
}

async function toggleContent(e) {
    const button = e.target;
    const article = button.parentElement.parentElement;
    const extra = article.children[1];

    const response = await fetch('http://localhost:3030/jsonstore/advanced/articles/details/' + button.id);
    const data = await response.json();

    const p = extra.children[0];
    p.textContent = data.content;

    
    if(extra.classList.contains('extra')) {
        button.textContent = 'Less';
        extra.classList.remove('extra');
    } else {
        button.textContent = 'More';
        extra.classList.add('extra');
    };
}

solution();