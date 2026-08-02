import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MtsMainPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By acceptCookiesButton = By.xpath("//button[text()='Принять']");
    private final By selectFormDropdown = By.xpath("//div[contains(@class, 'select')] | //div[@class='pay-select'] | //div[contains(text(), 'Услуги связи')]");
    private final By communicationServicesOption = By.xpath("//li[contains(., 'Услуги связи')] | //span[text()='Услуги связи']");

    private final By phoneField = By.id("connection-phone");
    private final By amountField = By.id("connection-sum");
    private final By emailField = By.id("connection-email");


    private final By continueButton = By.xpath("//*[@id='pay-connection']/button");


    public MtsMainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public MtsMainPage open() {
        driver.get("https://mts.by");
        return this;
    }

    public MtsMainPage acceptCookies() {
        wait.until(ExpectedConditions.elementToBeClickable(acceptCookiesButton)).click();
        return this;
    }

    public MtsMainPage scrollToPaymentBlock() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ((JavascriptExecutor) driver).executeScript(
                "var el = document.querySelector('section.pay, div.payment, main fieldset');" +
                        "if(el) { el.scrollIntoView({behavior: 'smooth', block: 'center'}); }"
        );
        return this;
    }

    public MtsMainPage selectCommunicationServices() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(selectFormDropdown)).click();
        } catch (Exception e) {
        }
        wait.until(ExpectedConditions.elementToBeClickable(communicationServicesOption)).click();
        return this;
    }

    public MtsMainPage fillPaymentForm(String phone, String amount, String email) {
        WebElement phoneInput = wait.until(ExpectedConditions.elementToBeClickable(phoneField));
        phoneInput.click();
        phoneInput.clear();
        phoneInput.sendKeys(phone);

        WebElement amountInput = wait.until(ExpectedConditions.elementToBeClickable(amountField));
        amountInput.click();
        amountInput.clear();
        amountInput.sendKeys(amount);

        WebElement emailInput = wait.until(ExpectedConditions.elementToBeClickable(emailField));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys(email);

        return this;
    }


    public PaymentPopupPage clickContinueButton() {
        wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
        return new PaymentPopupPage(driver);
    }
}
