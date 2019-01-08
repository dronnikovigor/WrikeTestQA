import io.qameta.allure.junit4.DisplayName;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import steps.StepLogin;
import steps.StepQA;

import java.io.File;
import java.util.concurrent.TimeUnit;


@DisplayName("Site Test")
public class SiteTest {
    private static WebDriver driver;

    @BeforeClass
    public static void setup() {
        File file = new File("drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    @DisplayName("Test Case")
    public void testCase() {
        StepLogin homePageSteps = new StepLogin(driver);
        homePageSteps.execStep2();
        homePageSteps.execStep3();
        homePageSteps.execStep4();

        StepQA qaPageSteps = new StepQA(driver);
        qaPageSteps.execStep5();
        qaPageSteps.execStep6();
        qaPageSteps.execStep7();
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
