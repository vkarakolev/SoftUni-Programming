const { createCard } = require('./E02_PlayingCards');

function printDeckOfCards(cards) {
    let result = [];

    for(let c of cards) {
        let currentCard;
        let face = c.substring(0, c.length - 1);
        let suit = c.charAt(c.length -1);
        
        try{

            currentCard = createCard(face, suit);
        } catch(Error) {
            console.log('Invalid card: ' + c);
            return;
        }

        result.push(currentCard.toString());
    }

    console.log(result.join(' '));
}

printDeckOfCards(['AS', '10D', 'KH', '2C']);
printDeckOfCards(['5S', '3D', 'QD', '1C']);