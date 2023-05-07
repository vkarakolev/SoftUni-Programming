function attachEvents() {
    document.getElementById('btnLoadPosts').addEventListener('click', loadPosts);
    document.getElementById('btnViewPost').addEventListener('click', viewPost);
}

async function loadPosts() {
    const select = document.getElementById('posts');
    const url = 'http://localhost:3030/jsonstore/blog/posts';

    const response = await fetch(url);
    const data = await response.json();


    window.localStorage.setItem('posts', data);

    select.innerHTML = '';

    Object.values(data).forEach(p => {
        const option = document.createElement('option');
        option.value = p.id;
        option.textContent = p.title;
        select.appendChild(option);
    });
}

async function viewPost() {
    const commentsUrl = 'http://localhost:3030/jsonstore/blog/comments';
    const postUrl = 'http://localhost:3030/jsonstore/blog/posts/';
    
    const postId = document.getElementById('posts').value;
    const postTitle = document.getElementById('post-title');
    const postBody = document.getElementById('post-body');
    const postComments = document.getElementById('post-comments');
    postComments.innerHTML = '';

    const postResponse = await fetch(postUrl + postId);
    const sellectedPost = await postResponse.json();

    const commentsResponse = await fetch(commentsUrl);
    const commentsData = await commentsResponse.json();

    const comments = Object.values(commentsData).filter(c => c.postId === postId);

    postTitle.textContent = sellectedPost.title;
    postBody.textContent = sellectedPost.body;

    comments.forEach(c => {
        const li = document.createElement('li');
        li.textContent = c.text
        postComments.appendChild(li);
    });
}

attachEvents();