package org.example;

public class MathService {

    public long factorial(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Число не может быть отрицательным");
        }
        long result = 1;
        for (int i = 1; i <= number; i++) {
            result *= i;
        }
        return result;
    }

    public double calculateTriangleArea(double base, double height) {
        if (base <= 0 || height <= 0) {
            throw new IllegalArgumentException("Размеры должны быть больше нуля");
        }
        return 0.5 * base * height;
    }

    public int addNumbers(int a, int b) {
        checkNonNegative(a, b);
        return a + b;
    }

    public int subtractNumbers(int a, int b) {
        checkNonNegative(a, b);
        return a - b;
    }

    public int divideNumbers(int a, int b) {
        checkNonNegative(a, b);
        if (b == 0) {
            throw new ArithmeticException("Деление на ноль запрещено");
        }
        return a / b;
    }

    public int multiplyNumbers(int a, int b) {
        checkNonNegative(a, b);
        return a * b;
    }

    public String compareNumbers(int a, int b) {
        checkNonNegative(a, b);

        if (a == b) {
            return "Числа равны";
        } else if (a > b) {
            return "Первое число больше второго";
        } else {
            return "Второе число больше первого";
        }
    }

    private void checkNonNegative(int a, int b) {
        if (a < 0 || b < 0) {
            throw new IllegalArgumentException("Числа не должны быть отрицательными");
        }
    }
}
