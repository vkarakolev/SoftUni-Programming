function createFigure() {
    class Figure {
        constructor() {
            this.units = 'cm';
        }

        get area() {

        }

        changeUnits(unit) {
            for(let prop of Object.keys(this)) {
                if(prop !== 'units') {
                    if(unit === 'mm') {
                        this[prop] = this[prop] * 10;
                    } else if (unit === 'm') {
                        prop = prop / 100;
                    } else {
                        if(this.units === 'mm') {
                            this[prop] = this[prop] / 10;
                        } else {
                            this[prop] = this[prop] * 100;
                        }
                    }
                }
            }

            this.units = unit;
        }

        toString() {
            return `Figures units: ${this.units}`;
        }
    }

    class Circle extends Figure {
        constructor(radius) {
            super();
            this.radius = Number(radius);
        }

        get area() {
            let modifiedPI = Math.PI;
            if(this.units === 'mm') {
                modifiedPI *= 10;
            } else if(this.units === 'm') {
                modifiedPI /= 100;
            }

            return Math.PI * this.radius * this.radius;
        }

        toString() {
            return `Figures units: ${this.units} Area: ${this.area} - radius: ${this.radius}`;
        }
    }

    class Rectangle extends Figure {
        constructor(width, height, units) {
            super();
            this.width = Number(width);
            this.height = Number(height);
            super.changeUnits(units);
        }

        get area() {
            return this.width * this.height;
        }

        toString() {
            return `Figures units: ${this.units} Area: ${this.area} - width: ${this.width}, height: ${this.height}`;
        }
    }

    return {
        Figure,
        Circle,
        Rectangle
    }
}

let classes = createFigure();
let Circle = classes.Circle;
let Rectangle = classes.Rectangle;

let c = new Circle(5);
console.log(c.area); // 78.53981633974483
console.log(c.toString()); // Figures units: cm Area: 78.53981633974483 - radius: 5
let r = new Rectangle(3, 4, 'mm'); 
console.log(r.area); // 1200
console.log(r.toString()); //Figures units: mm Area: 1200 - width: 30, height: 40 

r.changeUnits('cm');
console.log(r.area); // 12
console.log(r.toString()); // Figures units: cm Area: 12 - width: 3, height: 4
c.changeUnits('mm'); 
console.log(c.area); // 7853.981633974483
console.log(c.toString()); // Figures units: mm Area: 7853.981633974483 - radius: 50