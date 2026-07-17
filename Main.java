import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== ТЕСТ ЗАДАНИЯ 1: Студенты ===");

        // Создаем список студентов (картотеку)
        List<Student> students = new ArrayList<>();

        // Добавляем примеры оценок (математика, физика, ИТ)
        List<Integer> grades1 = List.of(4, 5, 4); // Средний балл 4.3 (отличник)
        List<Integer> grades2 = List.of(2, 3, 2); // Средний балл 2.3 (двоечник)
        List<Integer> grades3 = List.of(3, 3, 4); // Средний балл 3.3 (хорошист)

        students.add(new Student("Соня", "QA-01", 1, grades1));
        students.add(new Student("Петя", "QA-01", 1, grades2));
        students.add(new Student("Юля", "QA-02", 2, grades3));

        System.out.println("Студенты до проверки деканатом:");
        for (Student s : students) {
            System.out.println(s.name + ", Курс: " + s.course + ", Оценки: " + s.grades);
        }

        // Запускаем робота-чистильщика и переводчика
        processStudents(students);

        System.out.println("\nСтуденты после работы деканата (двоечников отчислили, остальных перевели):");
        for (Student s : students) {
            System.out.println(s.name + ", Курс: " + s.course);
        }

        System.out.println("\nИщем, кто учится на 2 курсе:");
        printStudents(students, 2);


        System.out.println("\n=== ТЕСТ ЗАДАНИЯ 2: Телефонный Справочник ===");
        Phonebook phonebook = new Phonebook();

        // Добавляем телефоны (у Ивановых будет два номера!)
        phonebook.add("Иванов", "+7-999-111-22-33");
        phonebook.add("Иванов", "+7-999-555-66-77");
        phonebook.add("Петров", "+7-999-333-44-55");

        // Проверяем поиск
        System.out.println("Номера Ивановых: " + phonebook.get("Иванов"));
        System.out.println("Номера Петровых: " + phonebook.get("Петров"));
        System.out.println("Номера Сидоровых (кого нет): " + phonebook.get("Сидоров"));
    }

    // Робот-чистильщик и переводчик для Задания 1
    public static void processStudents(List<Student> students) {
        // Используем специальный инструмент Iterator, чтобы безопасно удалять элементы на бегу
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();

            // Считаем сумму оценок
            double sum = 0;
            for (int grade : student.grades) {
                sum += grade;
            }
            double average = sum / student.grades.size(); // Находим средний балл

            // Если балл меньше 3 — отчисляем (удаляем из списка)
            if (average < 3) {
                iterator.remove();
            } else {
                // Иначе — переводим на следующий курс
                student.course++;
            }
        }
    }

    // Робот-глашатай для Задания 1
    public static void printStudents(List<Student> students, int course) {
        for (Student student : students) {
            if (student.course == course) {
                System.out.println("Студент: " + student.name + " обучается на курсе " + course);
            }
        }
    }
}

// Класс Студент (карточка)
class Student {
    String name;
    String group;
    int course;
    List<Integer> grades;

    public Student(String name, String group, int course, List<Integer> grades) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = grades;
    }
}

// Класс Телефонный Справочник для Задания 2
class Phonebook {
    // Создаем карту: Фамилия (String) -> Список номеров (List<String>)
    private HashMap<String, List<String>> book = new HashMap<>();

    // Метод добавления номера
    public void add(String surname, String phoneNumber) {
        // Если такой фамилии еще нет в справочнике — создаем для нее пустой список номеров
        if (!book.containsKey(surname)) {
            book.put(surname, new ArrayList<>());
        }
        // Добавляем номер телефона в список этой фамилии
        book.get(surname).add(phoneNumber);
    }

    // Метод поиска номеров
    public List<String> get(String surname) {
        // Если фамилия есть — отдаем список номеров, если нет — отдаем пустой красивый список
        return book.getOrDefault(surname, new ArrayList<>());
    }
}