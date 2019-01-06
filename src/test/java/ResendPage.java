import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

class ResendPage {
    private WebDriver driver;

    private static String PAGE_URL = "https://wrike.com/resend/";

    @FindBy(xpath = "//form[@class='survey-form' and 1]/div[@class='radio' and 1]/label[@class='switch' and 1]/button[@class='switch__button' and 1]")
    private List<WebElement> btns;
    @FindBy(xpath = "//button[@class='submit wg-btn wg-btn--navy js-survey-submit']")
    private WebElement createBtn;

    ResendPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    void waitForLoad() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//p[@class='h4 subtitle']"))));
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//iframe[contains(@src,'www.google.com')]"))));
        WebElement iframe = driver.findElement(By.xpath("//iframe[contains(@src,'www.google.com')]"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("//span[text()='NO']")).click();
        driver.switchTo().defaultContent();
    }

    void clickInterestedRadio() {
        int i = (int) (Math.random() * (1 + 1));
        System.out.println(btns.size());
        if (i < btns.size())
            btns.get(i).click();
        else
            btns.get(0).click();
    }

    void clickMembersRadio() {
        int i = 2 + (int) (Math.random() * ((6 - 2) + 1));
        if (i < btns.size())
            btns.get(i).click();
        else
            btns.get(0).click();
    }

    void clickProcessRadio() {
        int i = 7 + (int) (Math.random() * ((9 - 7) + 1));
        System.out.println(btns.size());
        if (i < btns.size())
            btns.get(i).click();
        else
            btns.get(0).click();
    }

    void clickCreateBtn() {
        createBtn.click();
    }

    boolean isFieldsFilled() {
        return createBtn.isEnabled();
    }

    boolean isPageOpened() {
        return driver.getPageSource().contains("Help us provide you the best possible experience");
    }
}
