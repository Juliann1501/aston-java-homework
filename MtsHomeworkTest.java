import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class MtsHomeworkTest {
    private WebDriver driver;
    private MtsMainPage mainPage;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        mainPage = new MtsMainPage(driver);
    }

    @Test
    public void testWorkflow() {
        mainPage.open()
                .acceptCookies()
                .scrollToPaymentBlock()
                .selectCommunicationServices()
                .fillPaymentForm("297777777", "10", "test@test.by");


        PaymentPopupPage popupPage = mainPage.clickContinueButton();
        popupPage.waitForPageLoad();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
