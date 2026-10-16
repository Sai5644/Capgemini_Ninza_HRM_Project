package ecom.ninzahrm.Resources;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import BaseClassUtility.BaseClass1;
import GenericUtility.Screenshot;
import rmgPom.ResourcesPOM;

public class ResourcesTest extends BaseClass1 {

    String fileName = "praveen-resume(1).pdf";

    @Test(priority = 1, groups = {"pos", "smoke"})
    public void uploadValidFileTest() throws Exception {

        ResourcesPOM resources = new ResourcesPOM(driver);

        resources.getResourcesMenu();
        resources.clickUploadFile();

        resources.chooseFile("C:\\Users\\DELL\\Downloads\\praveen-resume(1).pdf");

        resources.clickUploadFileSubmit();

        Thread.sleep(2000);

        Assert.assertTrue(driver.getPageSource().contains(fileName),"Uploaded file was not found");

        Reporter.log("Valid file upload test passed", true);
        
    }

    @Test(priority = 2, groups = {"pos", "smoke"})
    public void searchExistingFileTest() throws Exception {

        ResourcesPOM resources = new ResourcesPOM(driver);

        resources.getResourcesMenu();
        resources.searchFile(fileName);

        Thread.sleep(2000);

        Assert.assertFalse(driver.findElements(By.xpath("//*[normalize-space()='" + fileName + "']")).isEmpty(),"Existing file was not found");

        Reporter.log("Existing file search test passed", true);
        
    }

    @Test(groups = {"neg","ST"})
    public void searchInvalidFileTest() throws Exception {

        ResourcesPOM resources = new ResourcesPOM(driver);
        String invalidFile = "file_not_found_12345.pdf";

        resources.getResourcesMenu();
        resources.searchFile(invalidFile);

        Thread.sleep(2000);

        Assert.assertTrue(driver.findElements(By.xpath("//*[normalize-space()='" + invalidFile + "']")).isEmpty(), "Unexpected matching file found");

        Reporter.log("Invalid file search test passed", true);
        Screenshot.takeScreenshot(driver, "Search_Invalid_File");
    }

    @Test( groups = {"neg","FunT"})
    public void uploadWithoutFileTest() throws Exception {

        ResourcesPOM resources = new ResourcesPOM(driver);

        resources.getResourcesMenu();
        resources.clickUploadFile();
        resources.clickUploadFileSubmit();

        Thread.sleep(1000);

        Assert.assertTrue(driver.findElement(By.id("upload-file")).isDisplayed(),"Upload form was not displayed");

        Reporter.log("Upload without file test executed", true);
        Screenshot.takeScreenshot(driver, "Upload_Without_File");
    }
}
