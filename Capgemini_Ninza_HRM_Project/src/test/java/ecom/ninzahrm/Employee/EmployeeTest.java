package ecom.ninzahrm.Employee;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import BaseClassUtility.BaseClass1;
import GenericUtility.ExcelUtility;
import GenericUtility.Screenshot;
import rmgPom.EmployeePOM;

public class EmployeeTest extends BaseClass1 {

    ExcelUtility eu = new ExcelUtility();

    @Test(priority = 1,groups = {"pos", "smoke"})
    public void validEmployeeTest() throws Exception {

        String employeeName = eu.getData("Sheet2", 2, 0);
        String email = eu.getData("Sheet2", 2, 1);
        String phone = eu.getData("Sheet2", 2, 2);
        String username = eu.getData("Sheet2", 2, 3);
        String designation = eu.getData("Sheet2", 2, 4);
        String experience = eu.getData("Sheet2", 1, 5);
        String project = eu.getData("Sheet2", 1, 6);

        EmployeePOM employee = new EmployeePOM(driver);

        employee.getEmployeeMenu();
        employee.getAddEmployee();

        employee.getEmployeeName(employeeName);
        employee.getEmail(email);
        employee.getPhone(phone);
        employee.getUsername(username);
        employee.getDesignation(designation);
        employee.getExperience(experience);
        employee.getProject(project);
        employee.getAdd();

        Thread.sleep(1000);

        Assert.assertTrue(driver.getPageSource().contains(employeeName),"Employee not found in the list");

        Reporter.log("Valid employee test passed", true);
    }

    @Test(groups = {"neg", "smoke"})
    public void invalidEmailTest() throws Exception {

        String employeeName = eu.getData("Sheet2", 9, 0);
        String email = eu.getData("Sheet2", 9, 1);
        String phone = eu.getData("Sheet2", 9, 2);
        String username = eu.getData("Sheet2", 9, 3);
        String designation = eu.getData("Sheet2", 9, 4);
        String experience = eu.getData("Sheet2", 9, 5);
        String project = eu.getData("Sheet2", 9, 6);

        EmployeePOM employee = new EmployeePOM(driver);

        employee.getEmployeeMenu();
        employee.getAddEmployee();

        employee.getEmployeeName(employeeName);
        employee.getEmail(email);
        employee.getPhone(phone);
        employee.getUsername(username);
        employee.getDesignation(designation);
        employee.getExperience(experience);
        employee.getProject(project);
        employee.getAdd();

        boolean emailRejected = driver.getPageSource().contains("Email*");

        Assert.assertTrue(emailRejected,"Expected blank email form validation");

        
        Reporter.log("Invalid email test passed", true);
        Screenshot.takeScreenshot(driver, "Invalid_Email");
    }

    @Test(groups = {"neg", "FunT"})
    public void blankNameTest() throws Exception {

        String email = eu.getData("Sheet2", 10, 1);
        String phone = eu.getData("Sheet2", 10, 2);
        String username = eu.getData("Sheet2", 10, 3);
        String designation = eu.getData("Sheet2", 10, 4);
        String experience = eu.getData("Sheet2", 10, 5);
        String project = eu.getData("Sheet2", 10, 6);

        EmployeePOM employee = new EmployeePOM(driver);

        employee.getEmployeeMenu();
        employee.getAddEmployee();

        employee.getEmployeeName("");
        employee.getEmail(email);
        employee.getPhone(phone);
        employee.getUsername(username);
        employee.getDesignation(designation);
        employee.getExperience(experience);
        employee.getProject(project);
        employee.getAdd();

        Thread.sleep(1000);

        boolean nameRejected = driver.getPageSource().contains("Add Employee");

        Assert.assertTrue(nameRejected,"Expected blank name form validation");

        Reporter.log("Blank name test passed", true);
        Screenshot.takeScreenshot(driver, "Blank_Name");
    }

    @Test(groups = {"neg", "IT"})
    public void blankEmailTest() throws Exception {

        String employeeName = eu.getData("Sheet2", 8, 0);
        String phone = eu.getData("Sheet2", 8, 2);
        String username = eu.getData("Sheet2", 8, 3);
        String designation = eu.getData("Sheet2", 8, 4);
        String experience = eu.getData("Sheet2", 8, 5);
        String project = eu.getData("Sheet2", 8, 6);

        EmployeePOM employee = new EmployeePOM(driver);

        employee.getEmployeeMenu();
        employee.getAddEmployee();

        employee.getEmployeeName(employeeName);
        employee.getEmail("");
        employee.getPhone(phone);
        employee.getUsername(username);
        employee.getDesignation(designation);
        employee.getExperience(experience);
        employee.getProject(project);
        employee.getAdd();

        Thread.sleep(1000);

        boolean emailRejected = driver.getPageSource().contains("Add Employee");

        Assert.assertTrue(emailRejected,"Expected blank email form validation");

        Reporter.log("Blank Name and email test passed", true);
        Screenshot.takeScreenshot(driver, "Blank_Name_Email");
    }

    @Test(priority = 2,groups = "smoke")
    public void deleteEmployeeTest() throws Exception {

        EmployeePOM employee = new EmployeePOM(driver);

        employee.getEmployeeMenu();

        employee.selectEmployeeByUsername("Priya Kumar");

        employee.clickDelete();
        Thread.sleep(1000);
        employee.confirmDelete();

        Reporter.log("Delete employee test passed", true);
        Screenshot.takeScreenshot(driver, "Delete_Employee");
    }
}
