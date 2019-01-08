package steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.ResendPage;

public class StepQA{
    private static WebDriver driver;
    private ResendPage resendPage;

    public StepQA(WebDriver driver) {
        StepQA.driver = driver;
        resendPage = new ResendPage(driver);
    }

    public void execStep5() {
        resendPage.waitForLoad();
        Assert.assertTrue(resendPage.isPageOpened());

        resendPage.clickInterestedRadio();
        resendPage.clickMembersRadio();
        resendPage.clickProcessRadio();
        Assert.assertTrue(resendPage.isFieldsFilled());
        resendPage.clickCreateBtn();
    }

    public void execStep6() {
        resendPage.clickResendBtn();
        resendPage.waitForResend();
        Assert.assertTrue(resendPage.isEmailResend());
    }

    public void execStep7() {
        Assert.assertTrue(resendPage.isTwitterBtnExist());
        Assert.assertTrue(resendPage.isTwitterBtnCorrect());
    }
}
