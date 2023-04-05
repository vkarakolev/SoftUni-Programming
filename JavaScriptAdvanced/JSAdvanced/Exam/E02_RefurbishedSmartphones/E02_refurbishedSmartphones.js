class RefurbishedSmartphones {
    constructor(retailer) {
        this.retailer = retailer;
        this.availableSmartphones = [];
        this.soldSmartphones = [];
        this.revenue = 0;
    }

    addSmartphone (model, storage, price, condition) {
        //Potential Error
        if(typeof model !== 'string' || model === '' || 
        storage < 0 || typeof storage !== 'number' || 
        price < 0 || typeof price !== 'number' || 
        typeof condition !== 'string' || condition === '') {
            throw new Error('Invalid smartphone!');
        }

        this.availableSmartphones.push({
            model, 
            storage, 
            price, 
            condition
        });

        return `New smartphone added: ${model} / ${storage} GB / ${condition} condition - ${price.toFixed(2)}$`;
    }

    sellSmartphone (model, desiredStorage) {
        let currentPhone = this.availableSmartphones.find(phone => phone.model === model);
        if(!currentPhone) {
            throw new Error(`${model} was not found!`);
        };

        let difference = desiredStorage - currentPhone.storage;
        if(difference > 0 && difference <= 128) {
            currentPhone.price = currentPhone.price * 0.9;
        } else if (difference > 128){
            currentPhone.price = currentPhone.price * 0.8;
        };

        let index = this.availableSmartphones.indexOf(currentPhone);
        this.availableSmartphones.splice(index, 1);

        this.soldSmartphones.push({
            model: currentPhone.model, 
            storage: currentPhone.storage, 
            soldPrice: currentPhone.price
        });

        this.revenue += currentPhone.price;
        return `${currentPhone.model} was sold for ${currentPhone.price.toFixed(2)}$`;
    }

    upgradePhones () {
        if(!this.availableSmartphones) {
            throw new Error('There are no available smartphones!');
        };

        let result = `Upgraded Smartphones:\n`;
        let buff = [];
        this.availableSmartphones.forEach(phone => {
            phone.storage = phone.storage * 2;
            buff.push(`${phone.model} / ${phone.storage} GB / ${phone.condition} condition / ${phone.price.toFixed(2)}$`);
        });
        result += buff.join(`\n`);
        return result;
    }

    salesJournal (criteria) {
        if(criteria === 'storage' || criteria === 'model') {
            if(criteria === 'storage') {
                this.soldSmartphones.sort((a, b) => b.storage - a.storage);
            } else {
                this.soldSmartphones.sort((a, b) => () => {a.model.localeComapre(b.model)});
            };
    
            let result = `${this.retailer} has a total income of ${this.revenue}$\n${this.soldSmartphones.length} smartphones sold:\n`;
    
            let buff = [];
            this.soldSmartphones.forEach(p => {
                buff.push(`${p.model} / ${p.storage} GB / ${p.soldPrice.toFixed(2)}$`)
            });
            result += buff.join(`\n`);
            return result;
        } else {
            throw new Error('Invalid criteria!');
        };
    }
}

let retailer = new RefurbishedSmartphones('SecondLife Devices');
retailer.addSmartphone('Samsung S20 Ultra', 256, 1000, 'good');
retailer.addSmartphone('Iphone 12 mini', 128, 800, 'perfect');
retailer.addSmartphone('Xiaomi Redmi Note 10 Pro', 128, 330, 'perfect');
retailer.sellSmartphone('Samsung S20 Ultra', 256);
retailer.sellSmartphone('Xiaomi Redmi Note 10 Pro', 256);
console.log(retailer.salesJournal('model'));
