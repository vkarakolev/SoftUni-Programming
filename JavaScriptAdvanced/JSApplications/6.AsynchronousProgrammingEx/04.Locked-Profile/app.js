async function lockedProfile() {
    const response = await fetch('http://localhost:3030/jsonstore/advanced/profiles');
    const profiles = await response.json();

    const main = document.getElementById('main');
    main.innerHTML = '';

    let counter = 1;
    Object.values(profiles).forEach(p => {
        
        const {username, email, age} = p;
        
        let profile = document.createElement('div');
        profile.classList.add('profile');
        debugger    
        profile.innerHTML = `
            <img src="./iconProfile2.png" class="userIcon" />
			<label>Lock</label>
			<input type="radio" name="user${counter}Locked" value="lock" checked>
			<label>Unlock</label>
			<input type="radio" name="user${counter}Locked" value="unlock"><br>
			<hr>
			<label>Username</label>
			<input type="text" name="user${counter}username" value="${username}" disabled readonly />
			<div class="user${counter}Username hiddenInfo">
				<hr>
				<label>Email:</label>
				<input type="email" name="user${counter}email" value="${email}" disabled readonly />
				<label>Age:</label>
				<input type="email" name="user${counter}age" value="${age}" disabled readonly />
			</div>`

        let button = document.createElement('button');
        button.textContent = 'Show more';
        profile.appendChild(button);

        button.addEventListener('click', showMore);

        main.appendChild(profile);
        counter++;
    });
}

function showMore(e) {
    const elements = e.target.parentElement.children;
    const locked = elements[2];
    if(locked.checked) {
        return;
    }

    const button = elements[elements.length - 1];
    const hiddenInfo = elements[elements.length - 2];
    let classes = hiddenInfo.classList;

    if(classes.contains('hiddenInfo')) {
        hiddenInfo.classList.remove('hiddenInfo');
        button.textContent = 'Hide it';
    } else {
        hiddenInfo.classList.add('hiddenInfo');
        button.textContent = 'Show more';
    }
}