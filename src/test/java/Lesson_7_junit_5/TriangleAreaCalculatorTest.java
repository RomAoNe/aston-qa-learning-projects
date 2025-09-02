package Lesson_7_junit_5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TriangleAreaCalculatorTest {
    @Test
    @DisplayName("Площадь треугольника со сторонами 3, 4, 5 равняется 6")
    void calculateAreaWithValidSides() {
        TriangleAreaCalculator triangleAreaCalculator = new TriangleAreaCalculator(3, 4, 5);
        double result = triangleAreaCalculator.calculateArea();
        double expected = 6;
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Исключение, если сумма двух сторон <= третьей")
    void calculateAreaWithImpossibleTriangle() {
        assertThrows(IllegalArgumentException.class, () -> new TriangleAreaCalculator(1, 2, 3));
    }

    @Test
    @DisplayName("Исключение, если одна или несколько сторон < 0")
    void calculateAreaWithNegativeSide() {
        assertThrows(IllegalArgumentException.class, () -> new TriangleAreaCalculator(-10, 9, 9));
    }

    @Test
    @DisplayName("Исключение, если одна или несколько сторон = 0")
    void calculateAreaWithZeroSide() {
        assertThrows(IllegalArgumentException.class, () -> new TriangleAreaCalculator(0, 2, 4));
    }
}