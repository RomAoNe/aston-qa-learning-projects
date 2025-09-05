package Lesson_3;

public class Main {
    public static void main(String[] args) {
        showProductsInfo(createProductArray());

        Park park = new Park();
        park.showAttractionsInfo();
    }

    public static Product[] createProductArray() {
        Product[] products = new Product[5];

        products[0] = new Product("Laptop Pro 15", "2023-05-14", "TechCorp", "USA", 1500, false);
        products[1] = new Product("Smartphone X", "2024-01-20", "MobileOne", "China", 900, true);
        products[2] = new Product("Gaming Mouse", "2023-09-05", "ClickMaster", "Germany", 75, false);
        products[3] = new Product("Wireless Keyboard", "2022-12-10", "KeyTech", "Japan", 120, false);
        products[4] = new Product("4K Monitor", "2023-07-28", "VisionMax", "South Korea", 650, true);

        return products;
    }

    public static void showProductsInfo(Product[] products) {
        for (Product product : products) {
            product.showInfo();
        }
    }
}