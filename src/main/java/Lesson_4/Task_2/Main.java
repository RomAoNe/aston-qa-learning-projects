package Lesson_4.Task_2;

public class Main {
    public static void main(String[] args) {
        Figure[] figures = {
                new Figure("Yellow", "Black"),
                new Circle("Blue", "White", 13),
                new Rectangle("Green", "Red", 10, 12),
                new Triangle("White", "Black", 10, 10, 10)
        };

        for (int i = 0; i < figures.length; i++) {
            figures[i].showInfo();
        }
    }
}