package org.example;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MtsHomeworkTest {

    private MtsMainPage mainPage = new MtsMainPage();

    @BeforeEach
    void setUp() {
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