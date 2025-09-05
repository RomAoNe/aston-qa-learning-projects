package Lesson_4.Task_2;

public class Figure {
    private String backgroundColor;
    private String borderColor;
    protected double area;
    protected double perimeter;

    public Figure(String backgroundColor, String borderColor) {
        this.backgroundColor = backgroundColor;
        this.borderColor = borderColor;
    }

    public void showInfo() {
        System.out.println("Perimeter: " + perimeter + " | Area: " + area +
                " | Background color: " + backgroundColor + " | Border color: " + borderColor);
    }
}