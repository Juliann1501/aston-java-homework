public class Plate {
    public int food;

    public Plate(int food) {
        this.food = food;
    }

    public boolean decreaseFood(int amount) {
        if (food >= amount) {
            food -= amount;
            return true;
        }
        return false;
    }

    public void addFood(int amount) {
        if (amount > 0) {
            food += amount;
            System.out.println("В миску добавили " + amount + " г. корма. Теперь там: " + food + " г.");
        }
    }

    public void printInfo() {
        System.out.println("В миске осталось: " + food + " г. корма.");
    }
}