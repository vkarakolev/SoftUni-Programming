package E02_PointInRectangle;

public class Rectangle {
    private final Point A;
    private final Point B;

    public Rectangle(Point a, Point b) {
        A = a;
        B = b;
    }

    public boolean contains(Point P) {
        return P.graterOrEquals(A) && P.LessOrEquals(B);
    }
}
