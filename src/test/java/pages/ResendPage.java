package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ResendPage {
    private WebDriver driver;

    private static String PAGE_URL = "https://wrike.com/resend/";

    @FindBy(xpath = "//form[@class='survey-form' and 1]/div[@class='radio' and 1]/label[@class='switch' and 1]/button[@class='switch__button' and 1]")
    private List<WebElement> btns;
    @FindBy(xpath = "//button[@class='submit wg-btn wg-btn--navy js-survey-submit']")
    private WebElement createBtn;
    @FindBy(xpath = "//button[@class='wg-btn wg-btn--white wg-btn--hollow button js-button']")
    private WebElement resendBtn;

    public ResendPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitForLoad() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//p[@class='h4 subtitle']"))));
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//iframe[contains(@src,'www.google.com')]"))));
        WebElement iframe = driver.findElement(By.xpath("//iframe[contains(@src,'www.google.com')]"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("//span[text()='NO']")).click();
        driver.switchTo().defaultContent();
    }

    public void waitForResend() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//p[@class='h4 subtitle']/span[@class='again' and 1]"))));
    }

    public void clickInterestedRadio() {
        int i = randomInt(0, 1);
        btns.get(i).click();
    }

    public void clickMembersRadio() {
        int i = randomInt(2, 6);
        btns.get(i).click();
    }

    public void clickProcessRadio() {
        int i = randomInt(7, 9);
        if (i == 9) {
            driver.findElement(By.xpath("//label[@class='switch switch--text switch--fullwidth']/button[@class='switch__button' and 1]")).click();
            driver.findElement(By.xpath("//input[@class='switch__input']")).sendKeys("need to think");
        }
        else
            btns.get(i).click();
    }

    public void clickCreateBtn() {
        createBtn.click();
    }

    public void clickResendBtn() {
        resendBtn.click();
    }

    public boolean isFieldsFilled() {
        return createBtn.isEnabled();
    }

    public boolean isPageOpened() {
        return driver.getPageSource().contains("Thank you for choosing Wrike!");
    }

    public boolean isEmailResend() {
        return driver.getPageSource().contains("again");
    }

    public boolean isTwitterBtnExist() {
        driver.findElement(By.xpath("//*[name()='a' and @*='https://twitter.com/wrike']"));
        return true;
    }

    public boolean isTwitterBtnCorrect() {
        driver.findElement(By.xpath("//*[name()='use' and " +
                "@*='/content/themes/wrike/dist/img/sprite/vector/footer-icons.symbol.svg?v1#twitter']"));
        return true;
    }

    private int randomInt(int from, int to) {
        return from + (int) (Math.random() * ((to - from) + 1));
    }
}
