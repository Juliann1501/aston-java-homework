import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;

public class MtsHomeworkTest {

    @Test
    public void testMtsPayBlock() {
        // Шаг 1: Говорим роботу открыть сайт МТС
        open("https://mts.by");

        // Шаг 2 (Задание 1): Проверяем, что на странице есть нужный заголовок
        $(byText("Онлайн пополнение без комиссии")).shouldBe(Condition.visible);

        // Шаг 2 (Задание 2): Проверяем, что видны логотипы платежных систем (ищем по картинке)
        $(".pay__partners").shouldBe(Condition.visible);

        // Шаг 2 (Задание 3): Нажимаем на ссылку "Подробнее о сервисе"
        $(byLinkText("Подробнее о сервисе")).click();

        // Закрываем появившееся окно/поп-ап (если оно мешает идти дальше)
        back();

        // Шаг 2 (Задание 4): Заполняем поле номера телефона и жмем кнопку
        // Сначала убедимся, что выбран вариант "Услуги связи"
        $(byText("Услуги связи")).click();

        // Находим поле ввода по подсказке "Номер телефона" и пишем туда цифры
        $(byAttribute("placeholder", "Номер телефона")).setValue("297777777");

        // Находим кнопку "Продолжить" и кликаем по ней
        $(byText("Продолжить")).click();
    }
}
