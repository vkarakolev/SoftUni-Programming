function solve() {
    const info = document.getElementById('info');
    const departBtn = document.getElementById('depart');
    const arriveBtn = document.getElementById('arrive');
    const url = 'http://localhost:3030/jsonstore/bus/schedule/';
    let id = 'depot'
    let stop;

    async function depart() {
        try {
            const response = await fetch(url + id);
            stop = await response.json();

            info.textContent = 'Next stop ' + stop.name;
            departBtn.disabled = true;
            arriveBtn.disabled = false;
            id = stop.next;
        } catch (err) {
            error();
        }
    }

    async function arrive() {
        try {
            info.textContent = 'Arriving at ' + stop.name;
            arriveBtn.disabled = true;
            departBtn.disabled = false;
        } catch (err) {
            error();
        }
    }

    function error() {
        info.textContent = 'Error';
        departBtn.disabled = true;
        arriveBtn.disabled = true;
    }

    return {
        depart,
        arrive
    };
}

let result = solve();