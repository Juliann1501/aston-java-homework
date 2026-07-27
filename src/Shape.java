import java.util.Arrays;

public interface Shape {
    double getArea();
    String getBorderColor();
    String getFillColor();
    double[] getSides();

    default double getPerimeter() {
        return Arrays.stream(getSides()).sum();
    }

    default void printCharacteristics() {
        System.out.printf("Фигура: %s [Периметр: %.2f, Площадь: %.2f, Цвет фона: %s, Цвет границ: %s]%n",
                this.getClass().getSimpleName(),
                getPerimeter(),
                getArea(),
                getFillColor(),
                getBorderColor()
        );
    }
}
