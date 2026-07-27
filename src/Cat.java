public class Cat extends Animal {
    public static int catCount = 0;
    public int appetite;
    public boolean isFull = false;

    public Cat(String name, int appetite) {
        super(name);
        this.appetite = appetite;
        catCount++;
    }

    public void eat(Plate plate) {
        if (plate.decreaseFood(appetite)) {
            isFull = true;
            System.out.println("Кот " + name + " съел " + appetite + " г. корма и теперь СЫТ.");
        } else {
            System.out.println("Коту " + name + " НЕ ХВАТИЛО еды в миске! Он остался ГОЛОДНЫМ.");
        }
    }

    @Override
    public void run(int distance) {
        if (distance <= 200) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else {
            System.out.println(name + " не может пробежать " + distance + " м. (Максимум 200 м)");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println(name + " не умеет плавать! Коты не плавают.");
    }
}