import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class ResendPage {
    private WebDriver driver;

    private static String PAGE_URL = "https://wrike.com/resend/";

    ResendPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    boolean isPageOpened() {
        return driver.getPageSource().contains("Help us provide you the best possible experience");
    }

    void waitForLoad() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//p[@class='h4 subtitle']"))));
    }

}
