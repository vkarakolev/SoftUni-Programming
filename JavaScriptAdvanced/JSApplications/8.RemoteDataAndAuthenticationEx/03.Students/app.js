window.onload = attachEvents;

function attachEvents() {
    document.getElementById('form').addEventListener('submit', onSubmit);
}

function onSubmit(e) {
    e.preventDefault();
    const formData = new FormData(e.target);
    const {firstName, lastName, facultyNumber, grade} = Object.fromEntries(formData.entries());
    e.target.reset();

    const url = 'http://localhost:3030/jsonstore/collections/students';
    const body = {
        firstName: firstName,
        lastName: lastName,
        facultyNumber: facultyNumber,
        grade: grade
    }

    sendStudentData(url, body);
}

async function sendStudentData(url, body) {
    const response = await fetch(url,{
        method: 'POST',
        headers: {
            'Constent-Type': 'application/json'
        },
        body: JSON.stringify(body)
    });

    const data = await response.json();
    getAllStudents();
}

async function getAllStudents() {
    const url = 'http://localhost:3030/jsonstore/collections/students';

    const response = await fetch(url);
    const data = await response.json();

    renderStudents(Object.values(data));
    return data;
}

function renderStudents(data) {
    const tbody = document.querySelector('tbody');

    data.forEach(e => {
        const tr = document.createElement('tr');
        Object.entries(e).forEach(([k, v]) => {
            if(k === '_id') {
                return;
            }

            const td = document.createElement('td');
            td.textContent = v;
            tr.appendChild(td);
        });

        tbody.appendChild(tr);
    });
}