function attachEvents() {
   document.getElementById('btnLoad').addEventListener('click', onLoadEntries);
   document.getElementById('btnCreate').addEventListener('click', onCreate);
}

async function onLoadEntries() {
    const response = await fetch('http://localhost:3030/jsonstore/phonebook');
    const data = await response.json();

    loadEntries(data);
}

function loadEntries(data) {
    const phonebook = document.getElementById('phonebook');
    phonebook.innerHTML = '';

    Object.values(data).map(e => {
        const btnDelete = document.createElement('button');
        btnDelete.id = 'btnDelete';
        btnDelete.textContent = 'Delete';
        btnDelete.addEventListener('click', onDeleteEntry);

        const li = document.createElement('li');
        li.textContent = `${e.person}:${e.phone}`;
        li.setAttribute('dataId', e._id);
        li.appendChild(btnDelete);
        phonebook.appendChild(li);
    });
}

function onDeleteEntry(e) {
    const li = e.target.parentElement;
    const id = li.getAttribute('dataId');

    deleteEntry(id);
    li.remove();
}

async function deleteEntry(id) {
    const url = `http://localhost:3030/jsonstore/phonebook/${id}`;
    const header = createHeaders('Delete', null);

    const response = await fetch(url, header);
    const data = response.json();
    return (data);
}

function onCreate() {
    const personInput = document.getElementById('person');
    const phoneInput = document.getElementById('phone');

    createEntry(personInput.value, phoneInput.value);
    personInput.value = '';
    phoneInput.value = '';
}

async function createEntry(person, phone) {
    const url = 'http://localhost:3030/jsonstore/phonebook';
    const body = {
        person: person,
        phone: phone
    };

    const header = createHeaders('Post', body);
    const response = await fetch(url, header);
    const data = await response.json();
    onLoadEntries();
    return(data);
}

function createHeaders(method, body) {
    return {
        method: `${method}`,
        header: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(body)
    }
}

attachEvents();