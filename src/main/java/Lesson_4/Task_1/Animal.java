package Lesson_4.Task_1;

public class Animal {
    private static int animalCount = 0;
    private String name;
    private int maxRunDistance;
    private int maxSwimDistance;

    public Animal(String name, int maxRunDistance, int maxSwimDistance) {
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxSwimDistance = maxSwimDistance;
        animalCount++;
    }

    public void showInfo() {
        System.out.print(name);
    }

    public String getName() {
        return name;
    }

    public void run(int runDistance) {
        if (runDistance > maxRunDistance) {
            System.out.println(name + " пробежал только " + maxRunDistance + " м. из " + runDistance);
        } else {
            System.out.println(name + " пробежал " + runDistance + " м.");
        }
    }

    public void swim(int swimDistance) {
        if (maxSwimDistance == 0) {
            System.out.println(name + " не умеет плавать.");
        } else if (swimDistance > maxSwimDistance) {
            System.out.println(name + " проплыл только " + maxSwimDistance + " м. из " + swimDistance);
        } else {
            System.out.println(name + " проплыл " + swimDistance + " м.");
        }
    }

    public static void showAnimalCount() {
        System.out.println("Всего животных: " + animalCount);
    }
}