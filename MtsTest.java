import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeAll;
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
    public void testMtsPaymentBlockWorkflow() {
        open("https://mts.by");

        if ($("#cookie-accept").is(visible)) {
            $("#cookie-accept").click();
            sleep(500);
        } else if ($x("//button[contains(text(), 'Принять')]").is(visible)) {
            $x("//button[contains(text(), 'Принять')]").click();
            sleep(500);
        }

        $(".pay__wrapper h2").scrollTo().shouldBe(visible);

        $(".pay__wrapper h2").shouldHave(Condition.text("Онлайн пополнение\nбез комиссии"));

        $(".pay__partners").shouldBe(visible);
        $(".pay__partners img[alt='Visa']").shouldBe(visible);
        $(".pay__partners img[alt='MasterCard']").shouldBe(visible);
        $(".pay__partners img[alt='Белкарт']").shouldBe(visible);

        $x("//a[contains(text(), 'Подробнее о сервисе')]").scrollTo().shouldBe(interactable, Duration.ofSeconds(5));
        $x("//a[contains(text(), 'Подробнее о сервисе')]").click();

        webdriver().shouldHave(urlContaining("poryadok-oplaty-i-bezopasnost"), Duration.ofSeconds(6));

        back();
        $(".pay__wrapper h2").scrollTo().shouldBe(visible);

        $(".select__header").shouldHave(Condition.text("Услуги связи"));

        $("#connection-phone").setValue("297777777");
        $("#connection-phone").shouldHave(Condition.value("(29)777-77-77"));

        $("#connection-sum").setValue("1");
        $("#connection-sum").shouldHave(Condition.value("1"));

        $(".pay__form button[type='submit']").shouldBe(interactable, Duration.ofSeconds(6));
        $(".pay__form button[type='submit']").click();

        webdriver().shouldHave(urlContaining("https://www.mts.by/"), Duration.ofSeconds(10));
    }
}
