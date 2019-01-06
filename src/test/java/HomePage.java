import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

class HomePage {
    private WebDriver driver;

    private static String PAGE_URL = "https://wrike.com";

    @FindBy(xpath = "//div[@class='r']/form[@class='wg-header__free-trial-form wg-form' and 1]/button[@class='wg-header__free-trial-button wg-btn wg-btn--green' and 1]")
    private WebElement startBtn;
    @FindBy(xpath = "//input[@class='wg-input modal-form-trial__input']")
    private WebElement emailField;
    @FindBy(xpath = "//button[@class='wg-btn wg-btn--blue modal-form-trial__submit']")
    private WebElement createBtn;

    HomePage(WebDriver driver) {
        this.driver = driver;
        driver.get(PAGE_URL);
        PageFactory.initElements(driver, this);
    }

    void clickStartBtn() {
        startBtn.click();
    }

    void fillInEmail(String email) {
        emailField.sendKeys(email);
    }

    void clickCreateBtn() {
        createBtn.click();
    }
}
