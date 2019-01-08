package steps;

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

    public void execStep2() {
        home.clickStartBtn();
    }

    public void execStep3() {
        home.fillInEmail(randomString(10) + "+wpt@wriketask.qaa");
    }

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
