import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;

public class MtsHomeworkTest {

    private MtsMainPage mainPage = new MtsMainPage();

    @BeforeEach
    void setUp() {
        // Подключаем автоматическое логирование и скриншоты для Allure
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));

        mainPage.openPage()
                .acceptCookies();
    }

    @Test
    void testMtsHomework() {
        mainPage.scrollToPaymentBlock();

        mainPage.checkFirstFieldPlaceholder("Номер телефона")
                .checkSumFieldPlaceholder("Сумма")
                .checkEmailFieldPlaceholder("E-mail для отправки чека");

        mainPage.selectService("Домашний интернет")
                .checkFirstFieldPlaceholder("Номер абонента")
                .checkSumFieldPlaceholder("Сумма")
                .checkEmailFieldPlaceholder("E-mail для отправки чека");

        mainPage.selectService("Рассрочка")
                .checkFirstFieldPlaceholder("Номер счета на 44")
                .checkSumFieldPlaceholder("Сумма")
                .checkEmailFieldPlaceholder("E-mail для отправки чека");

        mainPage.selectService("Задолженность")
                .checkFirstFieldPlaceholder("Номер счета на 2073")
                .checkSumFieldPlaceholder("Сумма")
                .checkEmailFieldPlaceholder("E-mail для отправки чека");

        mainPage.selectService("Услуги связи")
                .fillFormAndSubmit("297777777", "30", "test@test.by")
                .verifyPopupData("375297777777", "30.00");
    }
}
