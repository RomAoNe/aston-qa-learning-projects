package Lesson_7_testing;

import org.testng.annotations.Test;
import org.testng.Assert;

public class TriangleAreaCalculatorTest {
    @Test(description = "Площадь треугольника со сторонами 3, 4, 5 равна 6")
    public void testCalculateAreaWithValidSides(){
        TriangleAreaCalculator triangleAreaCalculator = new TriangleAreaCalculator(3,4,5);
        double expected = 6;
        double result = triangleAreaCalculator.calculateArea();
        Assert.assertEquals(result, expected);
    }

    @Test(description = "Исключение, если сумма двух сторон <= третьей",
    expectedExceptions = IllegalArgumentException.class)
    public void testCalculateAreaWithImpossibleTriangle(){
        new TriangleAreaCalculator(1,2,3);
    }

    @Test(description = "Исключение, когда одна или несколько сторон = 0",
    expectedExceptions = IllegalArgumentException.class)
    public void testCalculateAreaWithZeroSide(){
        new TriangleAreaCalculator(0,4,5);
    }

    @Test(description = "Исключение, когда одна или несколько сторон < 0",
    expectedExceptions = IllegalArgumentException.class )
    public void testCalculateAreaWithNegativeSide(){
        new TriangleAreaCalculator(-1, 4,5);
    }
}