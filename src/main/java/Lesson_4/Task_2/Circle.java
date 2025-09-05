package Lesson_4.Task_2;

public class Circle extends Figure implements Area, Perimeter {
    private double radius;

    public Circle(String backgroundColor, String borderColor, double radius) {
        super(backgroundColor, borderColor);
        this.radius = radius;
        area = calculateArea();
        perimeter = calculateCirclePerimeter(radius);
    }

    public double calculateArea() {
        return Math.PI * (radius * radius);
    }
}