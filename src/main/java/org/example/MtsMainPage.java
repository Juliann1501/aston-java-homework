package org.example;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selectors.byXpath;

public class MtsMainPage {

    private final SelenideElement paymentBlockTitle = $(withText("Онлайн пополнение"));
    private final SelenideElement selectButton = $(".select__header");
    private final SelenideElement submitButton = $(byXpath("//*[@id='pay-connection']/button"));

    private SelenideElement getFirstVisibleInput() {
        return $$(".pay__form input, .pay__wrapper input").filter(visible).get(0);
    }

    private SelenideElement getSumVisibleInput() {
        return $$(".pay__form input, .pay__wrapper input").filter(visible).get(1);
    }

    private SelenideElement getEmailVisibleInput() {
        return $$(".pay__form input, .pay__wrapper input").filter(visible).get(2);
    }

    public MtsMainPage openPage() {
        open("https://mts.by");
        return this;
    }

    public MtsMainPage acceptCookies() {
        executeJavaScript("var cookies = document.querySelector('.cookie__wrapper, #btn-cookie-accept, [class*=\"cookie\"], .cookie'); if(cookies) cookies.remove();");
        sleep(500);
        return this;
    }

    public MtsMainPage scrollToPaymentBlock() {
        paymentBlockTitle.shouldBe(visible).scrollTo();
        sleep(1000);
        return this;
    }

    public MtsMainPage selectService(String serviceName) {
        selectButton.shouldBe(visible).click();
        $(".select__list").$(withText(serviceName)).shouldBe(visible).click();
        sleep(2000);
        return this;
    }

    public MtsMainPage checkFirstFieldPlaceholder(String expectedPlaceholder) {
        getFirstVisibleInput().shouldHave(attribute("placeholder", expectedPlaceholder));
        return this;
    }

    public MtsMainPage checkSumFieldPlaceholder(String expectedPlaceholder) {
        getSumVisibleInput().shouldHave(attribute("placeholder", expectedPlaceholder));
        return this;
    }

    public MtsMainPage checkEmailFieldPlaceholder(String expectedPlaceholder) {
        getEmailVisibleInput().shouldHave(attribute("placeholder", expectedPlaceholder));
        return this;
    }

    public PaymentPopupPage fillFormAndSubmit(String phone, String sum, String email) {
        getFirstVisibleInput().shouldBe(visible).setValue(phone);
        getSumVisibleInput().shouldBe(visible).setValue(sum);
        getEmailVisibleInput().shouldBe(visible).setValue(email);

        $(byXpath("//*[@id='pay-connection']/button")).shouldBe(visible).click();
        sleep(5000);
        return new PaymentPopupPage();
    }
}