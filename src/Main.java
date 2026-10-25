
public final class Main {

    public static void main(String[] args) {

        Calculator calculator =
                new Calculator(new AddStrategy());

        check("Addition", calculator.calculate(8, 2), 10);

        calculator.setStrategy(new SubtractStrategy());
        check("Subtraction", calculator.calculate(8, 2), 6);

        calculator.setStrategy(new MultiplyStrategy());
        check("Multiplication", calculator.calculate(8, 2), 16);

        calculator.setStrategy(new DivideStrategy());
        check("Division", calculator.calculate(8, 2), 4);

        checkDivisionByZero(calculator);

        System.out.println("All 5 tests passed.");
    }

    private static void check(
            String name, double actual, double expected) {

        if (Double.compare(actual, expected) != 0) {
            throw new AssertionError(
                    name + ": expected " + expected
                            + ", got " + actual
            );
        }

        System.out.println("PASS: " + name + " = " + actual);
    }

    private static void checkDivisionByZero(
            Calculator calculator) {

        try {
            calculator.calculate(8, 0);

            throw new AssertionError(
                    "Expected ArithmeticException"
            );

        } catch (ArithmeticException exception) {
            System.out.println("PASS: Division by zero rejected");
        }
    }
}
