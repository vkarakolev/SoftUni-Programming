window.onload = attachEvents;
const url = `http://localhost:3030/jsonstore/collections/books`;

function attachEvents() {
    document.getElementById('loadBooks').addEventListener('click', loadAllBooks);
    document.querySelector('form').addEventListener('submit', onSubmit);
}

async function loadAllBooks() {
    const response = await fetch(url);
    const data = await response.json();

    renderBooks(Object.entries(data));
    return data;
}

function renderBooks(data) {
    const tbody = document.querySelector('tbody');
    tbody.innerHTML = '';

    data.forEach(([k, v]) => {
        const tr = document.createElement('tr');
        tr.setAttribute('bookId', k);
        tr.innerHTML = `
            <td>${v.title}</td>
            <td>${v.author}</td>`;

        const td = document.createElement('td');
        const editBtn = document.createElement('button');
        editBtn.textContent = 'Edit';
        editBtn.addEventListener('click', onEdit);

        const deleteBtn = document.createElement('button');
        deleteBtn.textContent = 'Delete';
        deleteBtn.addEventListener('click', onDelete);

        td.appendChild(editBtn);
        td.appendChild(deleteBtn);
        tr.appendChild(td);
        tbody.appendChild(tr);
    });
}

function onDelete(e) {
    const tr = e.target.parentElement.parentElement;
    const id = tr.getAttribute('bookId');

    deleteBook(id);
    tr.remove();
}

async function deleteBook(id) {
    const response = await fetch(url + `/${id}`, {
        method: 'DELETE',
    });

    const data = await response.json();
    return data;
}

function onEdit(e) {
    const form = document.querySelector('form');
    const tr = e.target.parentElement.parentElement;
    form.setAttribute('editId', tr.getAttribute('bookId'));

    form.children[0].textContent = 'Edit FORM';
    form.title.value = tr.children[0].textContent;
    form.author.value = tr.children[1].textContent;
    form.children[5].textContent = 'Save';
}

async function editBook(body) {
    const form = document.querySelector('form');
    const id = form.getAttribute('editId');

    const response = await fetch(url + `/${id}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(body)
    });

    const data = await response.json();

    form.children[0].textContent = 'FORM';
    form.children[5].textContent = 'Submit';
    loadAllBooks();
}

function onSubmit(e) {
    e.preventDefault();
    const formData = new FormData(e.target);
    const {title, author} = Object.fromEntries(formData.entries());
    const formLabel = e.target.children[0];

    if(!title || !author) {
        return;
    }
    
    const body = {
        author: author,
        title: title
    };

    
    if(formLabel.textContent !== 'Edit FORM') {
        createBook(body);
    } else {
        editBook(body);
    }
    
    e.target.reset();
}

async function createBook(body) {
    const response = await fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(body)
    });

    const data = await response.json();
    loadAllBooks();
}