package october20.calculator;

public class Calculator {
    public static void calculate(Operation operation, double a, double b) {
        System.out.println("Результат операции = " + operation.calculate(a, b));
    }
}
