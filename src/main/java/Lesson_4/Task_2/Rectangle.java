package Lesson_4.Task_2;

public class Rectangle extends Figure implements Area, Perimeter {
    private double height;
    private double width;

    public Rectangle(String backgroundColor, String borderColor, double height, double width) {
        super(backgroundColor, borderColor);

        this.height = height;
        this.width = width;
        perimeter = calculateRectanglePerimeter(height, width);
        area = calculateArea();
    }

    public double calculateArea() {
        return height * width;
    }
}