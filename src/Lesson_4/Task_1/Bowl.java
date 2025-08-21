package Lesson_4.Task_1;

public class Bowl {
    private int foodAmount;

    public Bowl(int foodAmount) {
        addFood(foodAmount);
    }

    public void addFood(int foodAmount) {
        if (foodAmount > 0) {
            this.foodAmount += foodAmount;
            System.out.println("В миску добавлено " + foodAmount + " ед. еды.");
        } else {
            System.out.println("Нельзя добавить отрицательное (" + foodAmount + ") количество еды");
        }
    }

    public boolean isFoodEnough(int desiredFood) {
        return desiredFood <= foodAmount;
    }

    public void showInfo() {
        System.out.println("В миске осталось " + foodAmount + " ед. еды.");
    }

    public void decreaseFood(int foodToRemove) {
        if (foodAmount >= foodToRemove) {
            foodAmount -= foodToRemove;
        }
    }
}