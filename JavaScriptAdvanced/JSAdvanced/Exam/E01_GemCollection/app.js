window.addEventListener("load", solve);

function solve() {
    
    let form = document.getElementsByTagName('form')[0];
    let addBtn = document.getElementById('add-btn');
    let nameInput = document.getElementById('gem-name');
    let colorInput = document.getElementById('color');
    let caratsInput = document.getElementById('carats');
    let priceInput = document.getElementById('price');
    let typeInput = document.getElementById('type');
    let saveBtn = elementFactory('button', 'Save to Collection');
    let editBtn = elementFactory('button', 'Edint Inforamtion');
    let cancelBtn = elementFactory('button', 'Cancel');
    let previewList = document.getElementById('preview-list');
    let collection = document.getElementById('collection');

    addBtn.addEventListener('click', addGem);
    editBtn.addEventListener('click', editGem);
    saveBtn.addEventListener('click', saveGem);
    cancelBtn.addEventListener('click', cancelGem);

    function addGem(e) {
        let nameValue = nameInput.value;
        let colorValue = colorInput.value;
        let caratsValue = caratsInput.value;
        let priceValue = priceInput.value;
        let typeValue = typeInput.value;

        if(!nameValue || !colorValue || !caratsValue || !priceValue || !typeValue) {
            return;
        };

        addBtn.disabled = true;

        let li = elementFactory('li');
        let article = elementFactory('article');
        let h = elementFactory('h4', nameValue);
        let colorP = elementFactory('p', `Color: ${colorValue}`);
        let caratsP = elementFactory('p', `Carats: ${caratsValue}`);
        let priceP = elementFactory('p', `Price: ${priceValue} $`);
        let typeP = elementFactory('p', `Type: ${typeValue}`);

        li.classList.add('gem-info');
        saveBtn.classList.add('save-btn');
        editBtn.classList.add('edit-btn');
        cancelBtn.classList.add('cancel-btn');
    
        article.appendChild(h);
        article.appendChild(colorP);
        article.appendChild(caratsP);
        article.appendChild(priceP);
        article.appendChild(typeP);
        li.appendChild(article);
        li.appendChild(saveBtn);
        li.appendChild(editBtn);
        li.appendChild(cancelBtn);

        previewList.appendChild(li);
        form.reset();
    }

    function editGem(e) {
        debugger;
        addBtn.disabled = false;
        let li = e.target.parentElement;
        let namePreview = li.getElementsByTagName('h4')[0];
        nameInput.value = namePreview.textContent;

        let colorPreview = li.getElementsByTagName('p')[0];
        colorInput.value = colorPreview.textContent.split(': ')[1];

        let caratsPreview = li.getElementsByTagName('p')[1];
        caratsInput.value = caratsPreview.textContent.split(': ')[1];

        let pricePreview = li.getElementsByTagName('p')[2];
        priceInput.value = pricePreview.textContent.split(' ')[1];

        let typePreview = li.getElementsByTagName('p')[3];
        typeInput.value = typePreview.textContent.split(': ')[1];

        previewList.removeChild(li);
    }

    function saveGem(e) {
        let previewArticle = previewList.children[0].children[0];
        let name = previewArticle.children[0].textContent;
        let color = previewArticle.children[1].textContent;
        let carats = previewArticle.children[2].textContent;
        let price = previewArticle.children[3].textContent;
        let type = previewArticle.children[4].textContent;
        let li = elementFactory('li');

        debugger;
        let paragraph = elementFactory('p', 
            `${name} - ${color}/ ${carats}/ ${price.slice(0, 8)}$/ ${type}`
        );
        paragraph.classList.add('collection-item');
        
        li.appendChild(paragraph);
        collection.appendChild(li);
        previewList.removeChild(previewArticle.parentElement);
        addBtn.disabled = false;
    }

    function cancelGem(e) {
        let li = previewList.children[0];
        previewList.removeChild(li);
        addBtn.disabled = false;
    }

    function elementFactory(tag, content = '') {
        const e = document.createElement(tag);
        e.innerHTML = content;
      
        return e;
    };
}