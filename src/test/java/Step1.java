import org.openqa.selenium.WebDriver;

import java.security.SecureRandom;

public class Step1 implements Steps {
    private static WebDriver driver;
    private static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static SecureRandom rnd = new SecureRandom();

    Step1(WebDriver driver) {
        Step1.driver = driver;
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
