import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class StepQA implements Steps {
    private static WebDriver driver;

    StepQA(WebDriver driver) {
        StepQA.driver = driver;
    }

    public void execStep() {
        ResendPage resendPage = new ResendPage(driver);
        resendPage.waitForLoad();
        Assert.assertTrue(resendPage.isPageOpened());

        resendPage.clickInterestedRadio();
        resendPage.clickMembersRadio();
        resendPage.clickProcessRadio();
        Assert.assertTrue(resendPage.isFieldsFilled());
        resendPage.clickCreateBtn();
    }
}
