package october27.classwork;

public class Divide implements Operation{
    private double a, b;

    public Divide(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public double calculate() throws InfinitePointException {
        if (Double.compare(b, 0.) == 0)
            throw new InfinitePointException("Результат деления - бесконечность");

        return a / b;
    }
}
