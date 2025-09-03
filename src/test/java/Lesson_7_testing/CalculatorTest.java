package Lesson_7_testing;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeMethod
    public void setUp() {
        calculator = new Calculator(10, 5);
    }

    @Test(description = "Сложение 10 и 5 возвращает 15")
    public void testAdd() {
        int expected = 15;
        int result = calculator.add();
        Assert.assertEquals(result, expected);
    }

    @Test(description = "Вычитание 5 из 10 возвращает 5")
    public void testSubtract() {
        int expected = 5;
        int result = calculator.subtract();
        Assert.assertEquals(result, expected);
    }

    @Test(description = "Умножение 10 на 5 возвращает 50")
    public void testMultiply() {
        int expected = 50;
        int result = calculator.multiply();
        Assert.assertEquals(result, expected);
    }

    @Test(description = "Деление 0 на 5 возвращает 0.000")
    public void testDivideZero(){
        Calculator zeroDivisor = new Calculator(0,5);
        double expected = 0.000;
        double result = zeroDivisor.divide();
        Assert.assertEquals(result, expected);
    }

    @Test(description = "Деление 10 на 5 возвращает 2")
    public void testDivide() {
        double expected = 2;
        double result = calculator.divide();
        Assert.assertEquals(result, expected);
    }

    @Test(description = "Деление 1 на 0 невозможно",
    expectedExceptions = ArithmeticException.class)
    public void testDivideByZero(){
        new  Calculator(1, 0).divide();
    }
}