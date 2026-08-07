package org.example;
import java.time.Duration;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byXpath;

public class PaymentPopupPage {

    private final com.codeborne.selenide.SelenideElement paymentIframe =
            $(byXpath("//iframe[contains(@class, 'bepaid') or contains(@src, 'checkout')]"));

    public PaymentPopupPage verifyPopupData(String expectedPhone, String expectedSum) {
        paymentIframe.shouldBe(visible, Duration.ofSeconds(15));
        switchTo().frame(paymentIframe.getWrappedElement());

        $("body").shouldHave(text(expectedSum));
        $("body").shouldHave(text(expectedPhone));

        switchTo().defaultContent();
        return this;
    }
}