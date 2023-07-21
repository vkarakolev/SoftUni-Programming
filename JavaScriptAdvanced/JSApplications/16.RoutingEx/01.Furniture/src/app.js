import { checkUserNav } from './auth.js';
import { page, render } from './lib.js';
import { showCatalog } from './views/catalog.js';
import { showCreate } from './views/create.js';
import { showDashboard } from './views/dashboard.js';
import { showDetails } from './views/details.js';
import { showEdit } from './views/edit.js';
import { showHome } from './views/home.js';
import { showLogin } from './views/login.js';
import { showMyFurniture } from './views/myFurniture.js';
import { showRegister } from './views/register.js';

function decorateContext(ctx, next) {
    ctx.render = function (content) {
        const main = document.querySelector('main');
        render(content, main);
    };
    next();

    ctx.checkUserNav = checkUserNav();
}

page(decorateContext);
page('index.html', '/');
page('/', showHome);
page('/catalog', showCatalog);
page('/create', showCreate);
page('/dashboard', showDashboard);
page('/catalog/:id', showDetails);
page('/edit', showEdit);
page('/login', showLogin);
page('/my-furniture', showMyFurniture);
page('/register', showRegister);

page.start();