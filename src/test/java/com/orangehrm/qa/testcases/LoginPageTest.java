package com.orangehrm.qa.testcases;

import com.orangehrm.qa.base.TestBase;
import com.orangehrm.qa.pages.DashboardPage;
import com.orangehrm.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {

    // Global Variables
    LoginPage loginPage;
    DashboardPage dashboardPage;

    public LoginPageTest(){
        // Call TestBase class constructor which initializes all properties
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        loginPage = new LoginPage();
    }

    @Test(priority = 1)
    public void loginPageTitleTest() throws InterruptedException {
        String title = loginPage.validateLoginPageTitle();
        Thread.sleep(3000);
        System.out.println("Actual title"+title);
        Assert.assertEquals(title, "OrangeHRM");
    }

    @Test(priority = 2)
    public void testValidateLoginPanel() {
        boolean flag = loginPage.validateLoginPanel();
        Assert.assertTrue(flag);
    }

    @Test(priority = 3)
    public void loginTest() {
        dashboardPage = loginPage.login("Admin", "admin123");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
