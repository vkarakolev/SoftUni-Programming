function GCD(x, y) {
    x = Math.abs(x);
    y = Math.abs(y);
    
    while(y) {
        var t = y;
        y = x % y;
        x = t;
    }

    console.log(x);
}

GCD(15, 5);
GCD(2154, 458);