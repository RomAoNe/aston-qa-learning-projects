package Lesson_7_testing;

public class NumberComparator {
    private final int firstNumber;
    private final int secondNumber;

    public NumberComparator(int firstNumber, int secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    public int compare() {
        if (firstNumber > secondNumber) {
            return 1;
        } else if (firstNumber < secondNumber) {
            return -1;
        } else {
            return 0;
        }
    }

    public void displayComparison() {
        if (compare() == 1) {
            System.out.println("Число " + firstNumber + " больше числа " + secondNumber);
        } else if (compare() == -1) {
            System.out.println("Число " + firstNumber + " меньше числа " + secondNumber);
        } else {
            System.out.println("Числа " + firstNumber + " и " + secondNumber + " равны");
        }
    }
}