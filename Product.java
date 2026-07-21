public class Product {
    // 1. Свойства нашего товара (что у него есть)
    public String name;              // Название
    public String productionDate;    // Дата производства
    public String manufacturer;      // Производитель
    public String country;           // Страна происхождения
    public int price;                // Цена
    public boolean isBooked;         // Состояние бронирования покупателем

    // 2. Робот-конструктор, который будет заполнять эти свойства при создании товара
    public Product(String name, String productionDate, String manufacturer, String country, int price, boolean isBooked) {
        this.name = name;
        this.productionDate = productionDate;
        this.manufacturer = manufacturer;
        this.country = country;
        this.price = price;
        this.isBooked = isBooked;
    }

    // 3. Метод, который будет выводить всю информацию о товаре в консоль
    public void printInfo() {
        System.out.println("Товар: " + name);
        System.out.println("  Дата производства: " + productionDate);
        System.out.println("  Производитель: " + manufacturer + " (" + country + ")");
        System.out.println("  Цена: " + price + " руб.");
        System.out.println("  Забронирован: " + (isBooked ? "Да" : "Нет"));
        System.out.println("----------------------------------------------");
    }
}