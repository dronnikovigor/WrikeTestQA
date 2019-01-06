import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class SiteTest {
    private static WebDriver driver;
    private static String PAGE_URL = "https://wrike.com";

    @BeforeClass
    public static void setup() {
        File file = new File("drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testCase() {
        new StepLogin(driver).execStep();
        new StepQA(driver).execStep();
    }

    @AfterClass
    public static void tearDown() {
        //driver.quit();
    }
}
