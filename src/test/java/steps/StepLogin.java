package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.HomePage;

import java.security.SecureRandom;

public class StepLogin {
    private static WebDriver driver;
    private static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static SecureRandom rnd = new SecureRandom();
    private HomePage home;

    public StepLogin(WebDriver driver) {
        StepLogin.driver = driver;
        home = new HomePage(driver);
    }

    @Step("Click on Get Started")
    public void execStep2() {
        home.clickStartBtn();
    }

    @Step("Fill in email with random email using mask")
    public void execStep3() {
        home.fillInEmail(randomString(10) + "+wpt@wriketask.qaa");
    }

    @Step("Click on Create button")
    public void execStep4() {
        home.clickCreateBtn();
    }

    private String randomString(int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }
}
