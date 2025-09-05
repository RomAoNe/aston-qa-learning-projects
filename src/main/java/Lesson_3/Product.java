package Lesson_3;

public class Product {
    private final String title;
    private final String productionDate;
    private final String producer;
    private final String originCountry;
    private final int price;
    private final boolean isBooked;

    public Product(String name, String productionDate, String producer, String originCountry, int price, boolean isBooked) {
        this.title = name;
        this.productionDate = productionDate;
        this.producer = producer;
        this.originCountry = originCountry;
        this.price = price;
        this.isBooked = isBooked;
    }

    public void showInfo() {
        String info = title + " | " + productionDate + " | " + producer + " | " + originCountry + " | " + price + " bucks | " + isBooked;

        System.out.println(info);
    }
}