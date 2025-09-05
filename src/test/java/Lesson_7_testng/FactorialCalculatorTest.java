package Lesson_7_testng;

import org.testng.annotations.Test;
import org.testng.Assert;

public class FactorialCalculatorTest {
    @Test(description = "Факториал 0 равен 1")
    void testFactorialOfZero() {
        FactorialCalculator factorialCalculator = new FactorialCalculator(0);
        int expected = 1;
        int result = factorialCalculator.calculateFactorial();
        Assert.assertEquals(result, expected);
    }

    @Test(description = "Факториал 5 равен 120")
    void testFactorialOfFive() {
        FactorialCalculator factorialCalculator = new FactorialCalculator(5);
        int expected = 120;
        int result = factorialCalculator.calculateFactorial();
        Assert.assertEquals(result, expected);
    }

    @Test(description = "Факториал отрицательного числа не существует",
            expectedExceptions = IllegalArgumentException.class)
    void testFactorialOfNegative() {
        new FactorialCalculator(-5);
    }

    // Версия теста просто для закрепления темы, с блоком try catch
    @Test(description = "Факториала отрицательного числа не существует")
    void testFactorialOfNegativeReserved() {
        try {
            new FactorialCalculator(-5);
            Assert.fail();
        } catch (IllegalArgumentException e) {
        }
    }
}