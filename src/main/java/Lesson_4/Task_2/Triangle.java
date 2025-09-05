package Lesson_4.Task_2;

public class Triangle extends Figure implements Area, Perimeter {
    private double sideA;
    private double sideB;
    private double sideC;

    public Triangle(String backgroundColor, String borderColor, double sideA, double sideB, double sideC) {
        super(backgroundColor, borderColor);

        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        perimeter = calculatePerimeter(sideA, sideB, sideC);
        area = calculateArea();
    }

    public double calculateArea() {
        double semiPerimeter = perimeter / 2;

        return Math.sqrt(semiPerimeter * (semiPerimeter - sideA) * (semiPerimeter - sideB) * (semiPerimeter - sideC));
    }
}