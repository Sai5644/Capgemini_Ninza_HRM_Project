package rmgPom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPOM {

    WebDriver driver;

    public DashboardPOM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[normalize-space()='Dashboard']")
    private WebElement dashboardMenu;

    public void getDashboardMenu() {
        dashboardMenu.click();
    }
}
