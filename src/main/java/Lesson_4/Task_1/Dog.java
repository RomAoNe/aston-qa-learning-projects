package Lesson_4.Task_1;

public class Dog extends Animal {
    private static final int MAX_RUN_DISTANCE = 500;
    private static final int MAX_SWIM_DISTANCE = 10;
    private static int dogCount = 0;

    public Dog(String name) {
        super(name, MAX_RUN_DISTANCE, MAX_SWIM_DISTANCE);
        dogCount++;
    }

    public static void showDogCount() {
        System.out.println("Всего собак: " + dogCount);
    }
}