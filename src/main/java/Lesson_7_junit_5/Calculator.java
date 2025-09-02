package Lesson_7_junit_5;

public class Calculator {
    private final int firstNumber;
    private final int secondNumber;

    public Calculator(int firstNumber, int secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    public int add() {
        return firstNumber + secondNumber;
    }

    public int subtract() {
        return firstNumber - secondNumber;
    }

    public double divide() {
        if (secondNumber == 0) {
            throw new ArithmeticException("На ноль делить нельзя");
        }

        return (double) firstNumber / secondNumber;
    }

    public int multiply() {
        return firstNumber * secondNumber;
    }
}