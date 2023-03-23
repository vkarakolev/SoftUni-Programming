function sortTickets(inputArray, criteria) {
    class Ticket {
        constructor(destination, price, status) {
            this.destination = destination;
            this.price = price;
            this.status = status;
        }
    }

    let tickets = [];

    for(t of inputArray) {
        let [destination, price, status] = t.split('|');
        tickets.push(new Ticket(destination, price, status));
    }

    switch(criteria) {
        case 'destination': tickets.sort((a, b) => a.destination.localeCompare(b.destination)); break;
        case 'price': tickets.sort((a, b) => a.price.localeCompare(b.price)); break;
        case 'status': tickets.sort((a, b) => a.status.localeCompare(b.status)); break;
    }
    
    return tickets;
}

let result = sortTickets([
    'Philadelphia|94.20|available',
    'New York City|95.99|available',
    'New York City|95.99|sold',
    'Boston|126.20|departed'],
    'destination'
);
console.log(result);
