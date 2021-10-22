package october22.classwork.circle;

public class SinglePoint {
    private int x, y;
    private static SinglePoint point;

    public SinglePoint getInstance() {
        if (point == null) {
            point = new SinglePoint();
        }
        return point;
    }

    private SinglePoint() { }

    private SinglePoint(int a) {

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
