package E02_PointInRectangle;

public class Point {
    private final int x;
    private final int y;

    public Point (int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean graterOrEquals(Point a) {
        return a.x <= x && a.y <= y;
    }

    public boolean LessOrEquals(Point b) {
        return x <= b.x && y <= b.y;
    }
}
