package E02_Shapes;

public class Circle extends Shape {
    private Double radius;

    public Circle (Double radius) {
        this.radius = radius;
    }

    public final Double getRadius() {
        return radius;
    }

    @Override
    protected void calculatePerimeter() {
        Double result = 2 * Math.PI * radius;
    }

    @Override
    protected void calculateArea() {
        Double result = Math.PI * radius * radius;
    }
}
