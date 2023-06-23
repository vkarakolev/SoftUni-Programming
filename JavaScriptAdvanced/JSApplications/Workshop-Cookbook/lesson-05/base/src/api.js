const host = 'http://localhost:3030';

async function request(method, url, body) {
    const options = {
        method,
        headers: {}
    }

    if(body !== undefined) {
        options.headers['Content-Type'] = 'application/json';
        options.body = JSON.stringify(body);
    }

    const token = sessionStorage.getItem('accessToken');
    if(token) {
        options.headers['X-Authorization'] = token;
    }

    const response = await fetch(host + url, options);

    if(!response.ok) {
        const error = await response.json();
        throw new Error(error.message);
    };
   
    return response.json();
}

export const get = request.bind(null, 'get');
export const post = request.bind(null, 'post');
export const put = request.bind(null, 'put');
export const del = request.bind(null, 'delete');