package Lesson_7_testing;

public class FactorialCalculator {
    private final int factorialNumber;

    public FactorialCalculator(int factorialNumber) {
        if (factorialNumber < 0) {
            throw new IllegalArgumentException("Нельзя вычислить факториал отрицательного числа");
        }

        this.factorialNumber = factorialNumber;
    }

    public int calculateFactorial() {
        int factorial = 1;

        for (int i = 1; i <= factorialNumber; i++) {
            factorial *= i;
        }

        return factorial;
    }
}