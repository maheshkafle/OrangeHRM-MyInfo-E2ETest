package com.orangehrm.qa.testcases;

import com.orangehrm.qa.base.TestBase;
import com.orangehrm.qa.pages.DashboardPage;
import com.orangehrm.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DashboardPageTest extends TestBase {

    DashboardPage dashboardPage;
    LoginPage loginPage;

    public DashboardPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
        dashboardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    }

    @Test
    public void testValidateDashboardLogo(){
        Boolean flag = dashboardPage.validateDashboardLogo();
        Assert.assertTrue(flag);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}
