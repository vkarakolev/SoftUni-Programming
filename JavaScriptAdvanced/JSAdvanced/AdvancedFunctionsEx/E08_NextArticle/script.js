function getArticleGenerator(articles) {
    let arr = articles;

    return function () {
        if(arr.length != 0) {
            let div = document.querySelector('#content');
            let article = document.createElement('article')
            article.textContent = arr.shift();
            div.appendChild(article);
        }
    }
}
