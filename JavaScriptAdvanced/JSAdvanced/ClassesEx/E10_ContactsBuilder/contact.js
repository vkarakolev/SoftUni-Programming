class Contact {
    constructor(firstName, lastName, phone, email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this._online = false;
    }

    get online() {
        return this._online;
    }

    set online(value) {
        if(value) {
            this.titleDiv.classList.add('online');
        } else {
            this.titleDiv.classList.remove('online');
        }

        this._online = value;
    }

    elementFactory(tag, content = '') {
        const e = document.createElement(tag)
        e.innerHTML = content

        return e
    }

    render(id) {
        this.templ = this.elementFactory('article')
        this.titleDiv = this.elementFactory('div', `${this.firstName} ${this.lastName}`)
        this.infoBtn = this.elementFactory('button', '&#8505;')
        this.infoDiv =this.elementFactory('div', `<span>&phone; ${this.phone}</span><span>&#9993; ${this.email}</span>`)
        
        this.titleDiv.classList.add('title')
        this.infoDiv.classList.add('info')
        this.infoDiv.style.display = 'none'

        this.titleDiv.appendChild(this.infoBtn)
        this.templ.appendChild(this.titleDiv)
        this.templ.appendChild(this.infoDiv)

        this.infoBtn.addEventListener('click', () => {
            if(this.infoDiv.style.display === 'none') {
                this.infoDiv.style.display = 'block';
            } else {
                this.infoDiv.style.display = 'none';
            }
        });

        document.getElementById(id).appendChild(this.templ)
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