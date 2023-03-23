class Point{
    constructor(x, y) {
        this.x = x;
        this.y = y;
    }

    static distance(first, second) {
        return Math.sqrt(Math.pow(second.x - first.x, 2) + Math.pow(second.y - first.y, 2));
    }
}

let p1 = new Point(5, 5);

let p2 = new Point(9, 8);

console.log(Point.distance(p1, p2));