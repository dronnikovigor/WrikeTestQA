import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class Step2 implements Steps {
    private static WebDriver driver;

    Step2(WebDriver driver) {
        Step2.driver = driver;
    }

    public void execStep() {
        ResendPage resendPage = new ResendPage(driver);
        resendPage.waitForLoad();
        Assert.assertTrue(resendPage.isPageOpened());
    }
}
