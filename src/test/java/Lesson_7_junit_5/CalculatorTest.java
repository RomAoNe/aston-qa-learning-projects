package Lesson_7_junit_5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {
    @Test
    @DisplayName("Сложение 5 и 10 возвращает 15")
    public void sumValidNumbersTest() {
        Calculator calculator = new Calculator(5, 10);
        int expected = 15;
        int result = calculator.add();
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Вычитание 25 и 10 возвращает 15")
    public void subtractValidNumbersTest() {
        Calculator calculator = new Calculator(25, 10);
        int expected = 15;
        int result = calculator.subtract();
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Умножение 2 и 3 возвращает 6")
    public void multiplyValidNumbersTest() {
        Calculator calculator = new Calculator(2, 3);
        int expected = 6;
        int result = calculator.multiply();
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Деление 10 на 2 возвращает 5")
    public void divideValidNumbersTest() {
        Calculator calculator = new Calculator(10, 2);
        double expected = 5.000;
        double result = calculator.divide();
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Деление 0 на 5 возвращает 0.000")
    public void divideZeroTest() {
        Calculator calculator = new Calculator(0, 5);
        double expected = 0.000;
        double result = calculator.divide();
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Деление 4 на 0 вызывает исключение ArithmeticException")
    public void divideByZeroTest() {
        assertThrows(ArithmeticException.class, () -> new Calculator(4, 0).divide());
    }
}