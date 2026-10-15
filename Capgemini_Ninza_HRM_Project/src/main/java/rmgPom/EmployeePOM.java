package rmgPom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class EmployeePOM {

    WebDriver driver;

    public EmployeePOM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[normalize-space()='Employees']")
    private WebElement employeeMenu;

    @FindBy(xpath = "//*[text()='Add New Employee']")
    private WebElement addEmployeeButton;

    @FindBy(xpath = "//label[normalize-space()='Name*']/following-sibling::input")
    private WebElement employeeName;

    @FindBy(xpath = "//label[normalize-space()='Email*']/following-sibling::input")
    private WebElement email;

    @FindBy(xpath = "//label[normalize-space()='Phone*']/following-sibling::input")
    private WebElement phone;

    @FindBy(xpath = "//label[normalize-space()='Username*']/following-sibling::input")
    private WebElement username;

    @FindBy(xpath = "//label[normalize-space()='Designation*']/following-sibling::input")
    private WebElement designation;

    @FindBy(xpath = "//label[normalize-space()='Experience*']/following-sibling::input")
    private WebElement experience;

    @FindBy(xpath = "//label[normalize-space()='Project*']/following-sibling::select")
    private WebElement project;

    @FindBy(xpath = "//input[@value='Add']")
    private WebElement addButton;
    
    @FindBy(xpath = "//input[starts-with(@id,'checkbox_')]")
    private List<WebElement> employeeCheckboxes;
    
    @FindBy(xpath = "//span[text()='Delete']")
    private WebElement deleteButton;
    
    @FindBy(xpath = "//input[@value='Delete']")
    private WebElement confirmDeleteButton;
    
    @FindBy(xpath = "YOUR_ERROR_MESSAGE_XPATH")
    private WebElement errorMessage;
    
    @FindBy(xpath = "//tr[.//*[normalize-space()='USERNAME']]//input[@type='checkbox']")
    private WebElement employeeCheckbox;
    
    public void getEmployeeMenu() {
        employeeMenu.click();
    }

    public void getAddEmployee() {
        addEmployeeButton.click();
    }

    public void getEmployeeName(String value) {
        employeeName.sendKeys(value);
    }

    public void getEmail(String value) {
        email.sendKeys(value);
    }

    public void getPhone(String value) {
        phone.sendKeys(value);
    }

    public void getUsername(String value) {
        username.sendKeys(value);
    }

    public void getDesignation(String value) {
        designation.sendKeys(value);
    }

    public void getExperience(String value) {
        experience.sendKeys(value);
    }

    public void getProject(String value) {
        Select s = new Select(project);
        s.selectByVisibleText(value);
    }

    public void getAdd() {
        addButton.click();
    }
	public void selectEmployee(int index) {
		employeeCheckboxes.get(index).click();
		
	}

    public void clickDelete() {
        deleteButton.click();
    }
    public void confirmDelete() {
        confirmDeleteButton.click();
    }
    public String getErrorMessage() {
        return errorMessage.getText();
    }
    public void selectEmployeeByUsername(String username) {
        driver.findElement(By.xpath(
            "//*[normalize-space()='" + username + "']/ancestor::tr//input[@type='checkbox']"
        )).click();
    }


}