package rmgPom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LOGINPOM {

    WebDriver driver;

    public LOGINPOM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "username")
    private WebElement username;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;

    public void getun(String value) {
        username.sendKeys(value);
    }

    public void getpwd(String value) {
        password.sendKeys(value);
    }

    public void getlogin() {
        loginButton.click();
    }

}
