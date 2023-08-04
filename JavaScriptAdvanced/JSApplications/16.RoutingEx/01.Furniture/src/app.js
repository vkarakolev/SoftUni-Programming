import { checkUserNav } from './auth.js';
import { page, render } from './lib.js';
import { showCreate } from './views/create.js';
import { showDetails } from './views/details.js';
import { showEdit } from './views/edit.js';
import { showHome } from './views/home.js';
import { showLogin } from './views/login.js';
import { showMyFurniture } from './views/myFurniture.js';
import { showRegister } from './views/register.js';

function decorateContext(ctx, next) {
    ctx.render = function (content) {
        const container = document.querySelector('.container');
        render(content, container);
    };
    
    ctx.checkUserNav = function() {
        checkUserNav();
    };
    
    next();
}

page(decorateContext);
page('/', showHome);
page('index.html', '/');
page('/catalog', '/');
page('/create', showCreate);
page('/dashboard', '/');
page('/catalog/:id', showDetails);
page('/edit/:id', showEdit);
page('/login', showLogin);
page('/my-furniture', showMyFurniture);
page('/register', showRegister);

page.start();