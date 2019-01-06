import org.openqa.selenium.WebDriver;

import java.security.SecureRandom;

public class StepLogin implements Steps {
    private static WebDriver driver;
    private static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static SecureRandom rnd = new SecureRandom();

    StepLogin(WebDriver driver) {
        StepLogin.driver = driver;
    }

    public void execStep() {
        HomePage home = new HomePage(driver);
        home.clickStartBtn();
        home.fillInEmail(randomString(10) + "+wpt@wriketask.qaa");
        home.clickCreateBtn();
    }

    private String randomString(int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }
}
