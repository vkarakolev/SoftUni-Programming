import { months } from "./monthEnum.js";

attachEvents();
showView('years');

function attachEvents() {
    [...document.querySelectorAll('.day')].map(d => d.addEventListener('click', getTargetInfo));
    [...document.querySelectorAll('caption')].map(c => c.addEventListener('click', showPreviousView));
}

function getTargetInfo(e) {
    if(e.target.classList.contains('other-month')) {
        return;
    };
    
    const day = e.target.className === 'day' ? e.target : e.target.parentElement;
    const date = day.children[0].textContent;

    if (Number(date) >= 2020 && Number(date) <= 2023) {
        showView(`year-${date}`);
        sessionStorage.setItem('year', date);
    } else if (date.length > 2) {
        const year = sessionStorage.getItem('year');
        showView(`month-${year}-${months[date]}`);
    };
}

function showPreviousView(e) {
    const captionText = e.target.textContent;

    if (captionText === '2020 - 2023') {
        return;
    } else if (captionText.length == 4) {
        showView('years');
        sessionStorage.clear();
    } else {
        const year = sessionStorage.getItem('year');
        showView(`year-${year}`);
    };
}

function showView(id) {
    [...document.querySelectorAll('section')].forEach(s => s.style.display = 'none');
    document.getElementById(id).style.display = 'block';
}