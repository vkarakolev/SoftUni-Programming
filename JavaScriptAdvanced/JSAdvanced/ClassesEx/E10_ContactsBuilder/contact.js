class Contact {
    constructor(firstName, lastName, phone, email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.online = false;
    }

    render(id) {
        let article = document.createElement('article');
        article.classList.add('article');

        let titleDiv = document.createElement('div');
        titleDiv.classList.add('title');
        titleDiv.textContent = `${this.firstName} ${this.lastName}`;
        article.appendChild(titleDiv);

        let button = document.createElement('button');
        button.classList.add('title-button');
        button.textContent = '\u2139';
        titleDiv.appendChild(button);

        let infoDiv = document.createElement('div');
        infoDiv.classList.add('info');
        infoDiv.style.display = 'none';
        article.appendChild(infoDiv);

        let phoneSpan = document.createElement('span');
        phoneSpan.textContent = `\u260E ${this.phone}`;

        let emailSpan = document.createElement('span');
        emailSpan.textContent = `\u2709 ${this.email}`;

        infoDiv.appendChild(phoneSpan);
        infoDiv.appendChild(emailSpan);

        button.addEventListener('click', () => {
            if(infoDiv.style.display === 'none') {
                infoDiv.style.display = 'block';
            } else {
                infoDiv.style.display = 'none';
            }
        });

        let onlineProp = this.online;
        onlineProp.valueOf.addEventListener('change', () => {
            if(this.online) {
                titleDiv.classList.add('online');
            } else {
                titleDiv.classList.remove('online');
            }
        });

        document.getElementById(id).appendChild(article);
    }

}

let contacts = [
    new Contact("Ivan", "Ivanov", "0888 123 456", "i.ivanov@gmail.com"),
    new Contact("Maria", "Petrova", "0899 987 654", "mar4eto@abv.bg"),
    new Contact("Jordan", "Kirov", "0988 456 789", "jordk@gmail.com")
];
    
contacts.forEach(c => c.render('main')); 
// After 1 second, change the online status to true
setTimeout(() => contacts[1].online = true, 2000);