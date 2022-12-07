function lockedProfile() {
    let users = Array.from(document.getElementsByClassName('profile'));

    for(let user of users) {
        let button = user.getElementsByTagName('button')[0];
        button.addEventListener('click', showOrHide);
    }

    function showOrHide(e) {
        let user = e.target.parentElement;
        let unlockRadio = user.querySelectorAll('input[type=radio]')[1];
        
        if(!unlockRadio.checked) {
            return;
        }
        
        let button = e.target;
        let hidden = user.getElementsByTagName('div')[0];
        
        if(button.textContent === 'Show more'){
            hidden.style.display = 'block';
            button.textContent = 'Hide it';
        } else {
            hidden.style.display = 'none';
            button.textContent = 'Show more'; 
        }
    }
}