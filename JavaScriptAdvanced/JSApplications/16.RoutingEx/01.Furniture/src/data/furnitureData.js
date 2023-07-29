import { get } from "./api.js";

const endpoits = {
    'furniture': '/data/catalog',
    'byId': '/data/catalog/'
};

export async function getAll() {
    return await get(endpoits.furniture);
}

export async function getById(id) {
    return await get(endpoits.byId + id);
}