class Garden {
    constructor(spaceAvailable) {
        this.spaceAvailable = Number(spaceAvailable);
        this.plants = [];
        this.storage = [];
    }

    addPlant(plantName, spaceRequired) {
        if (this.spaceAvailable < spaceRequired) {
            throw new Error('Not enough space in the garden.');
        };

        this.plants.push({
            plantName,
            spaceRequired,
            ripe: false,
            quantity: 0
        });

        this.spaceAvailable -= spaceRequired;

        return `The ${plantName} has been successfully planted in the garden.`;
    }

    ripenPlant(plantName, quantity) {
        let currentPlant = this.plants.find(plant => plant.plantName === plantName);
        if (!currentPlant) {
            throw new Error(`There is no ${plantName} in the garden.`)
        };

        if (currentPlant.ripe) {
            throw new Error(`The ${plantName} is already ripe.`);
        };

        if (quantity <= 0) {
            throw new Error(`The quantity cannot be zero or negative.`);
        };

        currentPlant.ripe = true;
        currentPlant.quantity = quantity;

        let result = `${quantity} ${plantName}`;
        if (quantity == 1) {
            result += ' has ';
        } else {
            result += 's have '
        }
        result += 'successfully ripened.';

        return result;
    }

    harvestPlant(plantName) {
        let currentPlant = this.plants.find(plant => plant.plantName === plantName);

        if(!currentPlant) {
            throw new Error (`There is no ${plantName} in the garden.`);
        };

        if(!currentPlant.ripe) {
            throw new Error(`The ${plantName} cannot be harvested before it is ripe.`)
        };

        let index = this.plants.indexOf(currentPlant);
        this.plants.splice(index, 1);
        this.storage.push({
            plantName: currentPlant.plantName,
            quantity: currentPlant.quantity
        });

        this.spaceAvailable += currentPlant.spaceRequired;

        return `The ${plantName} has been successfully harvested.`;
    }

    generateReport() {
        let result = `The garden has ${this.spaceAvailable} free space left.\n`;
        result += `Plants in the garden: `;
        let buff = [];
        this.plants.forEach(p => buff.push(p.plantName));
        buff.sort();
        result += buff.join(', ');
        
        result += `\nPlants in storage: `;

        if(!this.storage) {
            result += `The storage is empty.`;
        } else {
            buff = [];
            this.storage.forEach(p => buff.push(`${p.plantName} (${p.quantity})`));
            result += buff.join(', ');
        }
        
        return result;
    }
}

const myGarden = new Garden(250);
console.log(myGarden.addPlant('apple', 20)); 
console.log(myGarden.addPlant('orange', 100)); 
console.log(myGarden.addPlant('raspberry', 10));
console.log(myGarden.ripenPlant('apple', 10)); 
console.log(myGarden.ripenPlant('orange', 1)); 
console.log(myGarden.harvestPlant('orange')); 
console.log(myGarden.generateReport());