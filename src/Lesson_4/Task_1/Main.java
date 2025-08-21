package Lesson_4.Task_1;

public class Main {
    public static void main(String[] args) {
        Bowl bowl = new Bowl(57);
        Cat[] cats = createCats();

        Dog dogBobik = new Dog("Бобик");
        Animal animalBeaver = new Animal("Бобр", 30, 200);

        dogBobik.run(150);
        dogBobik.swim(150);
        animalBeaver.run(34);
        animalBeaver.swim(34);
        cats[1].run(300);
        cats[1].swim(1);

        showCount();

        feedCats(cats, bowl);

        bowl.addFood(-567);
        bowl.addFood(100);
    }

    public static void feedCats(Cat[] cats, Bowl bowl) {
        for (Cat cat : cats) {
            cat.eat(bowl, 22);
            bowl.showInfo();
        }

        showCatsHunger(cats);
    }

    public static void showCatsHunger(Cat[] cats) {
        System.out.println("\nСостояние котов: ");

        for (Cat cat : cats) {
            cat.showInfo();
        }
    }

    public static Cat[] createCats() {
        Cat[] cats = new Cat[10];

        cats[0] = new Cat("Барсик");
        cats[1] = new Cat("Мурзик");
        cats[2] = new Cat("Снежок");
        cats[3] = new Cat("Лютик");
        cats[4] = new Cat("Васька");
        cats[5] = new Cat("Пушок");
        cats[6] = new Cat("Рыжик");
        cats[7] = new Cat("Томас");
        cats[8] = new Cat("Кузя");
        cats[9] = new Cat("Матроскин");

        return cats;
    }

    public static void showCount() {
        Cat.showCatCount();
        Dog.showDogCount();
        Animal.showAnimalCount();
    }
}