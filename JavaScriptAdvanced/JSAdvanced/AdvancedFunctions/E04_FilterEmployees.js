function filterEmp(data, criteriaData) {
    let employees = Array.from(JSON.parse(data));
    let criteria = criteriaData.split('-')[0];
    let value = criteriaData.split('-')[1];

    let counter = 0;
    for(let e of employees) {
        if(e.hasOwnProperty(criteria) && e[criteria] === value || criteria === 'all') {
            console.log(`${counter}. ${e.first_name} ${e.last_name} - ${e.email}`)
            counter++;
        }
    }
}

filterEmp(`[{

    "id": "1",
    
    "first_name": "Ardine",
    
    "last_name": "Bassam",
    
    "email": "abassam0@cnn.com",
    
    "gender": "Female"
    
    }, {
    
    "id": "2",
    
    "first_name": "Kizzee",
    
    "last_name": "Jost",
    
    "email": "kjost1@forbes.com",
    
    "gender": "Female"
    
    },
    
    {
    
    "id": "3",
    
    "first_name": "Evanne",
    
    "last_name": "Maldin",
    
    "email": "emaldin2@hostgator.com",
    
    "gender": "Male"
    
    }]`,
    
    'gender-Female');