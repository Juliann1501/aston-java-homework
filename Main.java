public class Main {

    public static void main(String[] args) {
        // Создаем правильную коробку 4х4, где лежат только цифры
        String[][] goodBox = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "1", "2", "3"},
                {"4", "5", "6", "7"}
        };

        // Создаем сломанную коробку (тут на одном этаже 5 комнат вместо 4)
        String[][] badSizeBox = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8", "9"},
                {"9", "1", "2", "3"},
                {"4", "5", "6", "7"}
        };

        // Создаем коробку с буквой-вредителем "Х" вместо цифры
        String[][] badDataBox = {
                {"1", "2", "3", "4"},
                {"5", "6", "Х", "8"},
                {"9", "1", "2", "3"},
                {"4", "5", "6", "7"}
        };

        System.out.println("--- ТЕСТ 1: Проверяем правильный массив ---");
        try {
            int result = checkAndSum(goodBox);
            System.out.println("Сумма всех чисел в массиве: " + result);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Найдена ошибка: " + e.getMessage());
        }

        System.out.println("\n--- ТЕСТ 2: Подставляем массив неправильного размера ---");
        try {
            checkAndSum(badSizeBox);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Найдена ошибка размера: " + e.getMessage());
        }

        System.out.println("\n--- ТЕСТ 3: Подставляем массив с буквой внутри ---");
        try {
            checkAndSum(badDataBox);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Найдена ошибка данных: " + e.getMessage());
        }

        System.out.println("\n--- ТЕСТ 4: Специально ломаем массив (Пункт 4) ---");
        try {
            makeMistake();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Найдена классическая ошибка: Выход за границы массива!");
        }
    }

    // Наш главный робот-конвейер
    public static int checkAndSum(String[][] box) throws MyArraySizeException, MyArrayDataException {
        if (box.length != 4) {
            throw new MyArraySizeException("В массиве  должно быть ровно 4 строки!");
        }
        for (int i = 0; i < box.length; i++) {
            if (box[i].length != 4) {
                throw new MyArraySizeException("На строке " + i + " должно быть ровно 4 ячейки!");
            }
        }

        int totalSum = 0;
        for (int i = 0; i < box.length; i++) {
            for (int j = 0; j < box[i].length; j++) {
                try {
                    totalSum += Integer.parseInt(box[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Внимание! На строке " + i + ", в ячейке " + j + " лежит что-то иное вместо числа!");}
            }
        }
        return totalSum;
    }

    // Вредный робот для пункта 4
    public static void makeMistake() {
        String[] smallArray = {"Яблоко", "Банан"};
        // Специально просим выдать 5-й элемент (которого нет), чтобы программа закричала
        System.out.println(smallArray[5]);
    }
}

// Наши кастомные кричалки-ошибки
class MyArraySizeException extends Exception {
    public MyArraySizeException(String message) { super(message); }
}

class MyArrayDataException extends Exception {
    public MyArrayDataException(String message) { super(message); }
}