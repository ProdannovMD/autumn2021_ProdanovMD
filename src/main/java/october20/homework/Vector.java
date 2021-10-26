package october20.homework;

public class Vector {
    private final double x, y, z;

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double length() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    public double scalarMult(Vector v) {
        return x * v.getX() + y * v.getY() + z * v.getZ();
    }

    public Vector vectorMult(Vector v) {
        return new Vector(
                y * v.getZ() - z * v.getY(),
                z * v.getX() - x * v.getZ(),
                x * v.getY() - y * v.getZ()
        );
    }

    public double angleCos(Vector v) {
        return this.scalarMult(v) / (Math.abs(this.length()) * Math.abs(v.length()));
    }

    public Vector add(Vector v) {
        return new Vector(
                x + v.getX(),
                y + v.getY(),
                z + v.getZ()
        );
    }

    public Vector subtract(Vector v) {
        return new Vector(
                x - v.getX(),
                y - v.getY(),
                z - v.getZ()
        );
    }

    public static Vector[] getRandomVectors(int n) {
        Vector[] vectors = new Vector[n];
        for (int i = 0; i < n; i++) {
            vectors[i] = new Vector(Math.random(), Math.random(), Math.random());
        }
        return vectors;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    @Override
    public String toString() {
        return "Vector{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}
