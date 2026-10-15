
package ecom.ninzahrm.Dashboard;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import BaseClassUtility.BaseClass1;
import GenericUtility.Screenshot;
import rmgPom.DashboardPOM;

public class DashboardTest extends BaseClass1 {

    @Test(priority = 1,groups = {"smoke", "pos"})
    public void dashboardTest() throws Exception {

        DashboardPOM dashboard = new DashboardPOM(driver);
        Thread.sleep(2000);
        dashboard.getDashboardMenu();
          Thread.sleep(2000);
        Assert.assertTrue(driver.getPageSource().contains("Dashboard"),"Dashboard page not displayed");

        Reporter.log("Dashboard test passed", true);
        
    }

            @Test(groups = {"ST","neg"})
            public void invalidDashboardUrlTest() throws Exception {

                 driver.get("http://49.249.29.4:8091/invaliddashboard");

                  Thread.sleep(2000);

                  Assert.assertFalse(driver.getCurrentUrl().contains("invaliddashboard"),"Invalid Dashboard URL was accessible");

                  Reporter.log("Invalid Dashboard URL test passed", true);
                   Screenshot.takeScreenshot(driver, "Invalid_Dashboard_URL");
}

}
