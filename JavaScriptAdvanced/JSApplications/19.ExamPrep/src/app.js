import { page, render } from "./lib.js";
import { getUserData } from "./util.js";
import { showCatalog } from "./views/catalog.js";
import { showCreate } from "./views/create.js";
import { showDetails } from "./views/details.js";
import { showEdit } from "./views/edit.js";
import { showHome } from "./views/home.js";
import { showLogin } from "./views/login.js";
import { updateNav } from "./views/nav.js";
import { showRegister} from "./views/register.js";

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
page('/catalog', showCatalog);
page('/create', showCreate);
page('/catalog/:id', showDetails);
page('/edit/:id', showEdit);
page('/login', showLogin);
page('/register', showRegister);
updateNav();

page.start();

function renderContent(content) {
    render(content, root);
}