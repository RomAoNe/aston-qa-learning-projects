package Lesson_7_testng;

public class TriangleAreaCalculator {
    private final double sideA;
    private final double sideB;
    private final double sideC;

    public TriangleAreaCalculator(double sideA, double sideB, double sideC) {
        if (sideA <= 0 || sideB <= 0 || sideC <= 0) {
            throw new IllegalArgumentException("Длина каждой из сторон должна быть > 0");
        }

        if (sideA + sideB <= sideC || sideA + sideC <= sideB || sideB + sideC <= sideA) {
            throw new IllegalArgumentException("Треугольник с такими сторонами не существует");
        }

        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    public double calculateArea() {
        double semiPerimeter = (sideA + sideB + sideC) / 2;

        return Math.sqrt(semiPerimeter *
                (semiPerimeter - sideA) *
                (semiPerimeter - sideB) *
                (semiPerimeter - sideC));
    }
}