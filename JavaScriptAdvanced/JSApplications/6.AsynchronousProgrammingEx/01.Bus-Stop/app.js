async function getInfo() {
    const inputField = document.getElementById('stopId');
    const id = inputField.value;
    const stopName = document.getElementById('stopName');
    const buses = document.getElementById('buses');
    
    buses.innerHTML = '';
    inputField.value = '';

    try {
        const response = await fetch('http://localhost:3030/jsonstore/bus/businfo/' + id);
        const stop = await response.json();
    
        stopName.textContent = stop.name;
      
        const stopBuses = Array.from(Object.entries(stop.buses));
        stopBuses.map(bus => {
            const li = document.createElement('li');
            li.textContent = `Bus ${bus[0]} arrives in ${bus[1]} minutes`;
            buses.appendChild(li);
        });
    } catch (err) {
        stopName.textContent = 'Error';
    }
}