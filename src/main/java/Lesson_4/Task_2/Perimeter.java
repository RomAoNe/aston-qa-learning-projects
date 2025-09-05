package Lesson_4.Task_2;

public interface Perimeter {
    default double calculatePerimeter(double... sides) {
        double perimeter = 0;

        for (double side : sides) {
            perimeter += side;
        }

        return perimeter;
    }

    default double calculateRectanglePerimeter(double height, double width) {
        return 2 * (height + width);
    }

    default double calculateCirclePerimeter(double radius) {
        return 2 * Math.PI * radius;
    }
}