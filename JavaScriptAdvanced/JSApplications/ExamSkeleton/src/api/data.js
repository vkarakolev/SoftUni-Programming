import { del, get, post, put } from "./api.js"


const endpoints = {
    'getAll': '/data/motorcycles?sortBy=_createdOn%20desc',
    'byId': '/data/motorcycles/',
    'motoCollection': '/data/motorcycles',
    'byModel': (model) => `/data/motorcycles?where=model%20LIKE%20%22${model}%22`
}

export async function getAll() {
    return get(endpoints.getAll);
}

export async function getById(id) {
    return get(endpoints.byId + id);
}

export async function create(data) {
    return post(endpoints.motoCollection, data);
}

export async function deleteMotorcycle(id) {
    return del(endpoints.byId + id);
}

export async function edit(id, data) {
    return put(endpoints.byId + id, data);
}

export async function searchByModel(model) {
    return get(endpoints.byModel(model));
}