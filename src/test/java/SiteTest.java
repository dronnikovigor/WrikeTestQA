import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;

public class SiteTest {
    private static WebDriver driver;
    private static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static SecureRandom rnd = new SecureRandom();

    @BeforeClass
    public static void setup() {
        File file = new File("drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://wrike.com");
    }

    @Test
    public void testCase() {
        WebElement startBtn = driver.findElement(By.xpath("//div[@class='r']/form[@class='wg-header__free-trial-form wg-form' and 1]/button[@class='wg-header__free-trial-button wg-btn wg-btn--green' and 1]"));
        startBtn.click();

        WebElement emailField = driver.findElement(By.xpath("//input[@class='wg-input modal-form-trial__input']"));
        emailField.sendKeys(randomString(10)+"+wpt@wriketask.qaa");

        WebElement createBtn = driver.findElement(By.xpath("//button[@class='wg-btn wg-btn--blue modal-form-trial__submit']"));
        createBtn.click();
    }

    @AfterClass
    public static void tearDown() {
        //driver.quit();
    }

    String randomString( int len ){
        StringBuilder sb = new StringBuilder( len );
        for( int i = 0; i < len; i++ )
            sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
        return sb.toString();
    }
}
