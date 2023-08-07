import { del, get, post } from "./api.js"

const endpoints = {
    'getAll': '/data/pets?sortBy=_createdOn%20desc&distinct=name',
    'byId': '/data/pets/',
    'petsCollection': '/data/pets'
}

export async function getAll() {
    return get(endpoints.getAll);
}

export async function getById(id) {
    return get(endpoints.byId + id);
    
}

export async function deleteById(id) {
    return del(endpoints.byId + id);
}

export async function create(data) {
    return post(endpoints.petsCollection, data);
}

export async function edit(id, data) {
    return put(endpoints.byId + id, data);
}