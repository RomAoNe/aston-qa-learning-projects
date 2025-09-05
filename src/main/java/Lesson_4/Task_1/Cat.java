package Lesson_4.Task_1;

public class Cat extends Animal implements Eater {
    private static final int MAX_RUN_DISTANCE = 200;
    private static final int MAX_SWIM_DISTANCE = 0;
    private static int catCount = 0;
    private boolean isFull;

    public Cat(String name) {
        super(name, MAX_RUN_DISTANCE, MAX_SWIM_DISTANCE);
        isFull = false;
        catCount++;
    }

    @Override
    public void showInfo() {
        super.showInfo();

        if (isFull) {
            System.out.println(" неголоден.");
        } else {
            System.out.println(" голоден.");
        }
    }

    @Override
    public boolean tryEat(Bowl bowl, int desiredFood) {
        return (bowl.isFoodEnough(desiredFood));

    }

    @Override
    public void eat(Bowl bowl, int desiredFood) {
        if (tryEat(bowl, desiredFood)) {
            bowl.decreaseFood(desiredFood);
            System.out.print(getName() + " поел. ");
            isFull = true;
        } else {
            System.out.print(getName() + " не смог поесть, так как еды не хватило. ");
        }
    }

    public static void showCatCount() {
        System.out.println("Всего котов: " + catCount);
    }
}