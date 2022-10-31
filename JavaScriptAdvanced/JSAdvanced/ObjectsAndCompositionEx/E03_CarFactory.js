function factory(car) {
    let result = {};
    result.model = car.model;

    let engineEnum = {
        'Small engine': { power: 90, volume: 1800 },
        'Normal engine': { power: 120, volume: 2400 },
        'Monster engine': { power: 200, volume: 3500 }
    }

    if(car.power <= 90) {
        result.engine = engineEnum['Small engine'];
    } else if (car.power <= 120) {
        result.engine = engineEnum['Normal engine'];
    } else {
        result.engine = engineEnum['Monster engine'];
    };

    let carriageEnum = {
        'hatchback': { type: 'hatchback', color: car.color},
        'coupe': { type: 'coupe', color: car.color}
    }

    result.carriage = carriageEnum[car.carriage];

    if(car.wheelsize % 2 == 0) {
        car.wheelsize -= 1;
    };
    
    result.wheels = new Array(4);
    result.wheels.fill(car.wheelsize);

    return result;
}

factory({
    model: 'VW Golf II',
    power: 90,
    color: 'blue',
    carriage: 'hatchback',
    wheelsize: 14 
});

factory({ 
    model: 'Opel Vectra',
    power: 110,
    color: 'grey',
    carriage: 'coupe',
    wheelsize: 17 
});