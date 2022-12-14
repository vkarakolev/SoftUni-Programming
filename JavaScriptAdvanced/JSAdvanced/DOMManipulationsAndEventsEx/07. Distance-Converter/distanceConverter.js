function attachEventsListeners() {
    let button = document.querySelector('#convert').addEventListener('click', convert);

    function convert(e) {
        let input = e.target.parentElement.children[1].value;
        let from = e.target.parentElement.children[2].value;

        let distanceInM = 0; 
        switch(from) {
            case 'km':
                distanceInM = input * 1000
                break;
            case 'm': 
                distanceInM = input;
                break;
            case 'cm':
                distanceInM = input * 0.01;
                break;
            case 'mm':
                distanceInM = input * 0.001;
                break;
            case 'mi':
                distanceInM = input * 1609.34;
                break;
            case 'yrd':
                distanceInM = input * 0.9144;
                break;
            case 'ft':
                distanceInM = input * 0.3048;
                break;
            case 'in':
                distanceInM = input * 0.0254;
                break;
        }

        let to = document.querySelector('#outputUnits').value;       
        let result = 0;
        switch(to) {
            case 'km':
                result = distanceInM / 1000;
                break;
            case 'm': 
                result = distanceInM;
                break;
            case 'cm':
                result = distanceInM / 0.01;
                break;
            case 'mm':
                result = distanceInM / 0.001;
                break;
            case 'mi':
                result = distanceInM / 1609.34;
                break;
            case 'yrd':
                result = distanceInM / 0.9144;
                break;
            case 'ft':
                result = distanceInM / 0.3048;
                break;
            case 'in':
                result = distanceInM / 0.0254;
                break;
        }

        document.querySelector('#outputDistance').value = result;
    }
}