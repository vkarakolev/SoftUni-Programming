window.addEventListener("load", solve);

function solve() {
  let publishBtn = document.getElementById('publish-btn');
  let titleInput = document.getElementById('post-title');
  let categoryInput = document.getElementById('post-category');
  let contentInput = document.getElementById('post-content');
  let editBtn = elementFactory('button', 'Edit');
  let approveBtn = elementFactory('button', 'Approve');
  let reviewList = document.getElementById('review-list');
  let publishedList = document.getElementById('published-list');
  let clearBtn = document.getElementById('clear-btn');

  publishBtn.addEventListener('click', createPost);
  editBtn.addEventListener('click', editPost);
  approveBtn.addEventListener('click', approvePost);
  clearBtn.addEventListener('click', clearPosts) 

  function createPost(e) {
    let titleValue = titleInput.value;
    let categoryValue = categoryInput.value;
    let contentValue = contentInput.value;

    if(!titleValue || !categoryValue || !contentValue) {
      return;
    }

    let li = elementFactory('li');
    let article = elementFactory('article');
    let title = elementFactory('h4', `${titleValue}`);
    let category = elementFactory('p', `Category: ${categoryValue}`);
    let content = elementFactory('p', `Content: ${contentValue}`);

    li.classList.add('rpost');
    editBtn.classList.add('action-btn');
    editBtn.classList.add('edit');
    approveBtn.classList.add('action-btn');
    approveBtn.classList.add('approve');

    article.appendChild(title);
    article.appendChild(category);
    article.appendChild(content);
    li.appendChild(article);
    li.appendChild(editBtn);
    li.appendChild(approveBtn);

    reviewList.appendChild(li);

    titleInput.value= '';
    categoryInput.value = '';
    contentInput.value = '';
  };

  function editPost(e) {
    let li = e.target.parentElement;
    let titleReview = li.getElementsByTagName('h4')[0];
    titleInput.value = titleReview.textContent;

    let categoryReview = li.getElementsByTagName('p')[0];
    categoryInput.value = categoryReview.textContent.slice(10);

    let contentReview = li.getElementsByTagName('p')[1];
    contentInput.value = contentReview.textContent.slice(9);

    reviewList.removeChild(li);
  };

  function approvePost(e) {
    let li = e.target.parentElement;
    let edit = li.getElementsByTagName('button')[0];
    let approve = li.getElementsByTagName('button')[1];
    li.removeChild(edit);
    li.removeChild(approve);

    publishedList.appendChild(li);
  };

  function clearPosts(e) {
    Array.from(publishedList.children).forEach(li => li.remove());
  };

  function elementFactory(tag, content = '') {
    const e = document.createElement(tag);
    e.innerHTML = content;
  
    return e;
  };
}