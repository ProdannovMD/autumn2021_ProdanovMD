package october22.classwork.circle;

public class Circle {
    private Point point;

    public Circle(int x, int y) {
        this.point = new Point(x, y);
    }

    public int getX() {
        return point.getX();
    }

    public int getY() {
        return point.getY();
    }
}
