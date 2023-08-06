import { page, render } from "./lib.js";
import { getUserData } from "./util.js";
import { showHome } from "./views/home.js";
import { showLogin } from "./views/login.js";
import { updateNav } from "./views/nav.js";

const root = document.getElementById('content');

function decorateContext(ctx, next) {
    ctx.render = renderContent;
    ctx.updateNav = updateNav;

    const user = getUserData();
    if(user) {
        ctx.user = user;
    }

    next();
}

page(decorateContext);
page('/', showHome);
page('index.html', '/');
page('/catalog', () => console.log('catalog'));
page('/create', () => console.log('create'));
page('/catalog/:id', () => console.log('details'));
page('/edit/:id', () => console.log('edit'));
page('/login', showLogin);
page('/register', () => console.log('register'));
updateNav();

page.start();

function renderContent(content) {
    render(content, root);
}