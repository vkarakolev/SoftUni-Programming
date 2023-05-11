function attachEvents() {
    document.getElementById('submit').addEventListener('click', sendMessage);
    document.getElementById('refresh').addEventListener('click', loadMessages);
}

function createMessage() {
    const inputs = document.getElementsByTagName('input');
    const authorInput = inputs[0];
    const contentInput = inputs[1];

    const body = {
        author: authorInput.value,
        content: contentInput.value
    };

    authorInput.value = '';
    contentInput.value = '';

    return body;
}

async function sendMessage() {
    const body = createMessage();
    const response = await fetch ('http://localhost:3030/jsonstore/messenger', {
        method: 'POST',
        headers: {
            'Content-Type': "authentication/json"
        },
        body: JSON.stringify(body)
    });
}

async function loadMessages() {
    const textArea = document.getElementById('messages');

    const response = await fetch('http://localhost:3030/jsonstore/messenger');
    const data = Object.values(await response.json());

    const content = Object.values(data).map(m => `${m.author}: ${m.content}`).join('\n');
    textArea.textContent = content;
}

attachEvents();