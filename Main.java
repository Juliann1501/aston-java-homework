public class Main {
    public static void main(String[] args) {

        Product[] productsArray = new Product[5];

        productsArray[0] = new Product("Samsung S25 Ultra", "01.02.2025", "Samsung Corp.", "Korea", 5599, true);
        productsArray[1] = new Product("iPhone 17 Pro", "10.05.2025", "Apple Inc.", "USA", 6999, false);
        productsArray[2] = new Product("Xiaomi 15 Ultra", "20.03.2025", "Xiaomi Tech", "China", 4599, false);
        productsArray[3] = new Product("Asus ROG Phone 9", "12.04.2025", "ASUS", "Taiwan", 5299, true);
        productsArray[4] = new Product("Pixel 10 Pro", "05.06.2025", "Google", "USA", 4999, false);

        System.out.println("====== СПИСОК НАШИХ ТОВАРОВ ======");
        for (int i = 0; i < productsArray.length; i++) {
            productsArray[i].printInfo();
        }

        System.out.println("\n====== ПАРК И АТТРАКЦИОНЫ ======");

        Park centralPark = new Park("Центральный Парк Культуры");

        Park.Attraction rollerCoaster = centralPark.new Attraction("Американские горки", "10:00 - 22:00", 500);
        Park.Attraction ferrisWheel = centralPark.new Attraction("Колесо обозрения", "09:00 - 23:00", 350);

        rollerCoaster.printAttractionInfo();
        ferrisWheel.printAttractionInfo();
    }
}