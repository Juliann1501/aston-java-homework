import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
        System.out.println("Задача 5: " + isSumInInterval(10, 5));
        isPositiveOrNegative(-7);
        System.out.println("Задача 7: " + isNegative(5));
        printStringMultipleTimes("Привет!", 3);
        System.out.println("2026 високосный? " + isLeapYear(2026));
        invertArray();
        fillArray();
        multiplyLessThanSix();
        fillDiagonal();
        System.out.println("Задача 14: " + Arrays.toString(createArray(6, 8)));
    }

    public static void printThreeWords() {
        System.out.println("Orange\nBanana\nApple");
    }

    public static void checkSumSign() {
        int a = 15, b = -5;
        System.out.println((a + b >= 0) ? "Сумма положительная" : "Сумма отрицательная");
    }

    public static void printColor() {
        int value = 45;
        if (value <= 0) System.out.println("Красный");
        else if (value <= 100) System.out.println("Желтый");
        else System.out.println("Зеленый");
    }

    public static void compareNumbers() {
        int a = 8, b = 12;
        System.out.println((a >= b) ? "a >= b" : "a < b");
    }

    public static boolean isSumInInterval(int x, int y) {
        int sum = x + y;
        return sum >= 10 && sum <= 20;
    }

    public static void isPositiveOrNegative(int x) {
        System.out.println((x >= 0) ? "Число положительное" : "Число отрицательное");
    }

    public static boolean isNegative(int x) {
        return x < 0;
    }

    public static void printStringMultipleTimes(String str, int times) {
        for (int i = 0; i < times; i++) System.out.println(str);
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static void invertArray() {
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < arr.length; i++) arr[i] = 1 - arr[i];
        System.out.println("Задача 10: " + Arrays.toString(arr));
    }

    public static void fillArray() {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) arr[i] = i + 1;
        System.out.println("Задача 11: " + Arrays.toString(arr));
    }

    public static void multiplyLessThanSix() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr.length; i++) if (arr[i] < 6) arr[i] *= 2;
        System.out.println("Задача 12: " + Arrays.toString(arr));
    }

    public static void fillDiagonal() {
        int size = 5;
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == j || i + j == size - 1) matrix[i][j] = 1;
            }
        }
        System.out.println("Задача 13:");
        for (int i = 0; i < size; i++) System.out.println(Arrays.toString(matrix[i]));
    }

    public static int[] createArray(int len, int initialValue) {
        int[] arr = new int[len];
        Arrays.fill(arr, initialValue);
        return arr;
    }
}