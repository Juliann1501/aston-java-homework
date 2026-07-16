public class Main {
    public static void main(String[] args) {
        System.out.println("====== ЧАСТЬ 1: ЖИВОТНЫЕ И МИСКА ======");

        Dog bobik = new Dog("Бобик");
        Cat barsik = new Cat("Барсик", 20);
        Cat murzik = new Cat("Мурзик", 25);
        Cat pushok = new Cat("Пушок", 15);

        bobik.run(150);
        bobik.swim(5);
        barsik.run(250);
        barsik.swim(2);

        System.out.println();

        Plate plate = new Plate(50);
        plate.printInfo();

        Cat[] cats = {barsik, murzik, pushok};
        for (int i = 0; i < cats.length; i++) {
            cats[i].eat(plate);
        }

        plate.printInfo();
        System.out.println();

        System.out.println("Всего создано животных: " + Animal.animalCount);
        System.out.println("Из них собак: " + Dog.dogCount);
        System.out.println("Из них котов: " + Cat.catCount);

        System.out.println("\n====== ЧАСТЬ 2: ГЕОМЕТРИЧЕСКИЕ ФИГУРЫ ======");

        Shape[] shapes = {
                new Circle(5.0, "Красный", "Белый"),
                new Rectangle(4.0, 6.0, "Синий", "Желтый"),
                new Triangle(3.0, 4.0, 5.0, "Черный", "Зеленый")
        };

        for (int i = 0; i < shapes.length; i++) {
            System.out.println("Фигура #" + (i + 1));
            System.out.println("  Площадь: " + shapes[i].getArea());
            System.out.println("  Периметр: " + shapes[i].getPerimeter());
            System.out.println("  Цвет границы: " + shapes[i].getBorderColor());
            System.out.println("  Цвет заливки: " + shapes[i].getFillColor());
            System.out.println("----------------------------------------------");
        }
    }
}