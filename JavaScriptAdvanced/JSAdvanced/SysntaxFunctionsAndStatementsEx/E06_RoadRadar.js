function roadRadar(speed, area) {
    let limit;
    switch(area) {
        case 'motorway' : limit = 130; break;
        case 'interstate' : limit = 90; break;
        case 'city' : limit = 50; break;
        case 'residential' : limit = 20; break;
    }

    if(speed <= limit) {
        console.log(`Driving ${speed} km/h in a ${limit} zone`);
        return;
    }

    let difference = speed - limit;
    let severity;

    if(difference <= 20) {
        severity = 'speeding';
    } else if (difference <= 40) {
        severity = 'excessive speeding';
    } else {
        severity = 'reckless driving';
    }

    console.log(`The speed is ${difference} km/h faster than the allowed speed of ${limit} - ${severity}`);
}

roadRadar(40, 'city');
roadRadar(21, 'residential');
roadRadar(120, 'interstate');
roadRadar(200, 'motorway');