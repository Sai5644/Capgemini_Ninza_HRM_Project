package ecom.ninzahrm.Login;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import BaseClassUtility.BaseClass;
import GenericUtility.ExcelUtility;
import GenericUtility.Screenshot;
import rmgPom.LOGINPOM;

public class LoginTest extends BaseClass {

    ExcelUtility eu = new ExcelUtility();

    @Test(priority = 1,groups = {"pos", "smoke"})
    public void validUserLogin() throws Exception {

        String username = eu.getData("Sheet1", 1, 0);
        String password = eu.getData("Sheet1", 1, 1);

        LOGINPOM login = new LOGINPOM(driver);

        login.getun(username);
        login.getpwd(password);
        login.getlogin();

        Thread.sleep(2000);

        boolean result = !driver.getCurrentUrl().equals("http://49.249.29.4:8091/");

        Assert.assertTrue(result, "Valid user login failed");

        Reporter.log(username + " --> LOGIN IS PASSED", true);
    }

    @Test(groups = {"neg", "ST"})
    public void invalidUserLogin() throws Exception {

        String username = eu.getData("Sheet1", 2, 0);
        String password = eu.getData("Sheet1", 2, 1);

        LOGINPOM login = new LOGINPOM(driver);

        login.getun(username);
        login.getpwd(password);
        login.getlogin();

        Thread.sleep(1000);

        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        alert.accept();

        Assert.assertEquals(alertText, "Invalid Credentials","Unexpected alert message");

        Reporter.log("Invalid user login test PASSED", true);

        Screenshot.takeScreenshot(driver, "Invalid_User_Login");
    }

    @Test(groups = {"neg", "FunT"})
    public void emptyCredentialsLogin() throws Exception {
 
    	String username = eu.getData("Sheet1", 3, 0);
        String password = eu.getData("Sheet1", 3, 1);
        
        LOGINPOM login = new LOGINPOM(driver);

        login.getun(username);
        login.getpwd(password);
        login.getlogin();

        Thread.sleep(1000);

        Assert.assertEquals(driver.getTitle(), "Ninza HRM","Unexpected page after empty credentials login");
        
        Reporter.log("Empty credentials test PASSED", true);
        Screenshot.takeScreenshot(driver, "Empty_Credentials_Login1");

    }

    @Test(groups = {"neg", "IT"})
    public void invalidPasswordLogin() throws Exception {

        String username = eu.getData("Sheet1", 4, 0);
        String password = eu.getData("Sheet1", 4, 1);

        LOGINPOM login = new LOGINPOM(driver);

        login.getun(username);
        login.getpwd(password);
        login.getlogin();

        Thread.sleep(1000);

        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        alert.accept();

        Assert.assertEquals(alertText, "Invalid Credentials","Unexpected alert message for invalid password");

        Reporter.log("Invalid password test PASSED", true);

        Screenshot.takeScreenshot(driver, "Invalid_Password_Login");
    }
}