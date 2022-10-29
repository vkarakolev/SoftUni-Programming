function solve(name, population, treasury) {
    let city = {
        name: name,
        population: population, 
        treasury: treasury,
        taxRate: 10,
    
        collectTaxes() {
            this.treasury += this.population * this.taxRate 
        },

        applyGrowth(percentage) {
            this.population += this.population * percentage / 100
        },

        applyRecession(percentage) {
            this.treasury -= this.treasury * percentage / 100
        }
    };

    

    city.collectTaxes();
    console.log(city.treasury);
    city.applyGrowth(5);
    console.log(city.population);
    city.applyRecession(10);
    console.log(city.treasury);
    console.log(city);
}

solve('Tortuga', 7000, 15000);