package Lesson_7_junit_5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FactorialCalculatorTest {
    @Test
    @DisplayName("Факториал 0 равен 1")
    void testFactorialOfZero() {
        FactorialCalculator factorialCalculator = new FactorialCalculator(0);
        int result = factorialCalculator.calculateFactorial();
        int expected = 1;
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Факториал 5 равен 120")
    void testFactorialOfFive() {
        FactorialCalculator factorialCalculator = new FactorialCalculator(5);
        int result = factorialCalculator.calculateFactorial();
        int expected = 120;
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Фактриала отрицательного числа не существует")
    void testFactorialOfNegative() {
        assertThrows(IllegalArgumentException.class, () -> new FactorialCalculator(-5));
    }
}