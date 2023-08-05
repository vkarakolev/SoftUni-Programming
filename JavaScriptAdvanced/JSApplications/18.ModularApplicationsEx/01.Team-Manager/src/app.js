import { checkUserNav, logout } from "./data/auth.js";
import { page, render } from "./lib.js";
import { getUserData } from "./util.js";
import { showBrowseTeams } from "./views/browseTeams.js";
import { showHome } from "./views/home.js";
import { showLogin } from "./views/login.js";
import { showMyTeams } from "./views/myTeams.js";
import { showRegister } from "./views/register.js";

function decorateContext(ctx, next) {
    ctx.render = function (template) {
        const main = document.querySelector('main');
        render(template, main);
    };

    ctx.checkUserNav = function () {
        checkUserNav();
    };

    next();
}

function session(ctx, next) {
    const user = getUserData();

    if(user) {
        ctx.user = user;
    };

    next();
}

page(session);
page(decorateContext);
page('/', showHome);
page('/index.html', '/');
page('/browse-teams', showBrowseTeams);
page('/login', showLogin);
page('/register', showRegister);
page('/my-teams', showMyTeams);
page('/logout', onLogout);

page.start()

async function onLogout(ctx) {
    await logout();
    ctx.page.redirect('/');
}