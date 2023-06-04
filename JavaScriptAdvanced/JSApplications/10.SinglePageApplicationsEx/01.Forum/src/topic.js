
const url = 'http://localhost:3030/jsonstore/collections/myboard/posts';

async function getTopics(url) {
    const response = await fetch(url);
    const data = await response.json();

    return data;
}

function createTopic(topic) {
    const f = document.createDocumentFragment();
    const container = document.createElement('div');
    container.classList.add('topic-container');
    container.innerHTML = `
        <div class="topic-name-wrapper">
            <div class="topic-name">
                <a id="${topic._id}" class="topic-a" href="javascript:void(0)" class="normal">
                    <h2>${topic.topicName}</h2>
                </a>
                <div class="columns">
                    <div>
                        <p>Date: <time>${topic.date}</time></p>
                        <div class="nick-name">
                            <p>Username: <span>${topic.username}</span></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>`;

    f.appendChild(container);
    return f;
}

export async function appendTopics() {
    const container = document.querySelector('.topic-title');
    container.innerHTML = '';
    const data = await getTopics(url);
    const topics = Object.values(data);

    topics.forEach(t => {
        let fragment = createTopic(t);
        [...fragment.querySelectorAll('.topic-a')].map(a => a.addEventListener('click', showTopicView));
        container.appendChild(fragment);
    });
}

export function onSubmit(e) {
    e.preventDefault();
    
    if(e.submitter.textContent == 'Cancel') {
        e.target.reset();
        return;
    };

    const formData = new FormData(e.target);
    postTopic(formData);
    e.target.reset();
    appendTopics();
}

async function postTopic(formData) {
    const {topicName, username, postText} = Object.fromEntries(formData);
    const body = {
        topicName: topicName,
        username: username,
        postText: postText,
        date: new Date()
    };

    const response = await fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(body)
    });

    return await response.json();
}

export async function showTopicView(e) {
    const id = e.currentTarget.id;

    const topic = await getTopics(url + `/${id}`);

    //TO DO:

    document.getElementById('home-view').style.display = 'none';
    document.getElementById('topic-view').style.display = 'block';

    console.log(id);
}