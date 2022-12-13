function encodeAndDecodeMessages() {
    let buttons = document.querySelectorAll('button');
    buttons[0].addEventListener('click', encode);
    buttons[1].addEventListener('click', decode);
    let textAreas = document.querySelectorAll('textarea');
    let sender = textAreas[0];
    let reciever = textAreas[1];

    function encode(e) {
        let encoded = '';
        let currentText = sender.value;

        for(let i = 0; i < currentText.length; i++) {
            let currentCh = currentText[i].charCodeAt();
            encoded += String.fromCharCode(currentCh + 1);
        }

        reciever.value = encoded;
        sender.value = '';
    }
    
    function decode() {
        let decoded = '';
        let currentText = reciever.value;

        for(let i = 0; i < currentText.length; i++) {
            let currentCh = currentText[i].charCodeAt();
            decoded += String.fromCharCode(currentCh - 1);
        }

        reciever.value = decoded;       
    }
}