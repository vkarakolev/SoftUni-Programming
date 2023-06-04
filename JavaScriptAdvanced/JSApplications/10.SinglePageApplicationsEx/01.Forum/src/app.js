import { appendTopics, onSubmit, showTopicView} from "./topic.js";

const homeView = document.getElementById('home-view');

window.addEventListener('load', () => {
    showHomeView();
    attachEvents();
    
});

function showHomeView() {
    appendTopics();
    document.getElementById('home-view').style.display = 'block';
    document.getElementById('topic-view').style.display = 'none';
}

function attachEvents() {
    document.getElementById('topic-form').addEventListener('submit', onSubmit);
    document.querySelector('header a').addEventListener('click', showHomeView);
}