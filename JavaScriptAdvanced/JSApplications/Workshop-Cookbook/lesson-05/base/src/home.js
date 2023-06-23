import { showCatalog } from "./catalog.js";

let main;
let section;
let setActiveNav;

export function setupHome(targetMain, targetSection, onActiveNav) {
    main = targetMain;
    section = targetSection;
    setActiveNav = onActiveNav;
    section.querySelector('a').addEventListener('click', showCatalog);
}

export async function showHome() {
    setActiveNav('homeLink');
    //showRecent();
    main.appendChild(section);
}