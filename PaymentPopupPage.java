import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class PaymentPopupPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By paymentIframe = By.xpath("//iframe[contains(@class, 'bepaid') or contains(@src, 'checkout')]");

    public PaymentPopupPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public PaymentPopupPage waitForPageLoad() {
        wait.until(ExpectedConditions.presenceOfElementLocated(paymentIframe));
        return this;
    }
}
