package Lesson_3;

public class Park {
    private Attraction[] attractions;

    public Park() {
        createAttractions();
    }

    public void showAttractionsInfo() {
        for (Attraction attraction : attractions) {
            attraction.showInfo();
        }
    }

    private void createAttractions() {
        attractions = new Attraction[]{
                new Attraction("Колесо обозрения", "10:00 - 20:00", 300),
                new Attraction("Американские горки", "11:00 - 22:00", 500),
                new Attraction("Комната страха", "12:00 - 21:00", 400),
                new Attraction("Автодром", "10:00 - 20:00", 250),
                new Attraction("Карусель", "09:00 - 19:00", 150)
        };
    }

    private class Attraction {
        private final String title;
        private final String workTime;
        private final int price;

        private Attraction(String title, String workTime, int price) {
            this.title = title;
            this.workTime = workTime;
            this.price = price;
        }

        private void showInfo() {
            String info = "| " + title + " | " + workTime + " | " + price + " руб. |";
            System.out.println(info);
        }
    }
}