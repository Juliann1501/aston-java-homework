import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Configuration.browserSize;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;

public class MtsTest {

    @BeforeAll
    static void setUp() {
        browserSize = "1920x1080";
    }

    @Test
    @DisplayName("Сценарий проверки блока оплаты МТС и отправки формы")
    public void testMtsPaymentBlockWorkflow() {
        open("https://mts.by");

        // Принимаем куки, если появилось окно
        if ($("#cookie-accept").is(visible)) {
            $("#cookie-accept").click();
            sleep(500);
        } else if ($x("//button[contains(text(), 'Принять')]").is(visible)) {
            $x("//button[contains(text(), 'Принять')]").click();
            sleep(500);
        }

        // Скроллим к блоку оплаты и проверяем заголовки и логотипы партнеров
        $(".pay__wrapper h2").scrollTo().shouldBe(visible);
        $(".pay__wrapper h2").shouldHave(Condition.text("Онлайн пополнение\nбез комиссии"));

        $(".pay__partners").shouldBe(visible);
        $(".pay__partners img[alt='Visa']").shouldBe(visible);
        $(".pay__partners img[alt='MasterCard']").shouldBe(visible);
        $(".pay__partners img[alt='Белкарт']").shouldBe(visible);

        // Переходим по ссылке "Подробнее о сервисе"
        $x("//a[contains(text(), 'Подробнее о сервисе')]").scrollTo().shouldBe(interactable, Duration.ofSeconds(5));
        $x("//a[contains(text(), 'Подробнее о сервисе')]").click();

        // Проверяем, что перешли на страницу условий оплаты
        webdriver().shouldHave(urlContaining("poryadok-oplaty-i-bezopasnost"), Duration.ofSeconds(6));

        // Возвращаемся обратно на главную
        back();
        $(".pay__wrapper h2").scrollTo().shouldBe(visible);

        // Убеждаемся, что выбрана вкладка "Услуги связи"
        $(".select__header").shouldHave(Condition.text("Услуги связи"));

        // Используем посимвольный ввод sendKeys вместо setValue для правильной отработки маски сайта
        $("#connection-phone").shouldBe(visible).click();
        $("#connection-phone").clear();
        $("#connection-phone").sendKeys("297777777");

        // Пауза, чтобы JS-маска сайта МТС успела примениться к введенным цифрам
        sleep(500);
        $("#connection-phone").shouldHave(Condition.value("(29)777-77-77"));

        // Вводим рабочую сумму 209 посимвольно для вызова поп-апа оплаты
        $("#connection-sum").shouldBe(visible).click();
        $("#connection-sum").clear();
        $("#connection-sum").sendKeys("209");
        $("#connection-sum").shouldHave(Condition.value("209"));

        // Ждем кликабельности кнопки "Продолжить" и кликаем по ней
        $(".pay__form button[type='submit']").shouldBe(interactable, Duration.ofSeconds(6));
        $(".pay__form button[type='submit']").click();

        // ОЖИДАНИЕ РЕДИРЕКТА: Ждем, что форма ушла на обработку и URL содержит "mts"
        webdriver().shouldHave(urlContaining("mts"), Duration.ofSeconds(10));

        // Даем браузеру честные 5 секунд побыть открытым, чтобы окно оплаты полностью прогрузилось на экране
        sleep(5000);
    }

    // Эта логика гарантирует автоматическое закрытие браузера после каждого теста
    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }
}

