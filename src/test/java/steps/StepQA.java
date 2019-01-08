package steps;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.ResendPage;

public class StepQA {
    private static WebDriver driver;
    private ResendPage resendPage;

    public StepQA(WebDriver driver) {
        StepQA.driver = driver;
        resendPage = new ResendPage(driver);
    }

    @Step("Check for redirect. Fill in QA & assert answers are submitted")
    public void execStep5() {
        resendPage.waitForLoad();
        Assert.assertTrue(resendPage.isPageOpened());

        resendPage.clickInterestedRadio();
        resendPage.clickMembersRadio();
        resendPage.clickProcessRadio();
        Assert.assertTrue(resendPage.isFieldsFilled());
        resendPage.clickCreateBtn();
    }

    @Step("Resend email and assert it")
    public void execStep6() {
        resendPage.clickResendBtn();
        resendPage.waitForResend();
        Assert.assertTrue(resendPage.isEmailResend());
    }

    @Step("Check Twitter button and check it's image")
    public void execStep7() {
        Assert.assertTrue(resendPage.isTwitterBtnExist());
        Assert.assertTrue(resendPage.isTwitterBtnCorrect());
    }
}
