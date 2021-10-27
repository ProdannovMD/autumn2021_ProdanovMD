package october27.classwork;

public class Main {
    public static void main(String[] args) {
        Operation operation = new Divide(10, 0);
        try {
            double result = operation.calculate();
            System.out.println("Реузльтат деления = " + result);
        } catch (InfinitePointException e) {
            e.printMessage();
        } finally {
            System.out.println("test");
        }
    }
}
