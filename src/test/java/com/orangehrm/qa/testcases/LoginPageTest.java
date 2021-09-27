package com.orangehrm.qa.testcases;

import com.orangehrm.qa.base.TestBase;
import com.orangehrm.qa.pages.DashboardPage;
import com.orangehrm.qa.pages.LoginPage;
import com.orangehrm.qa.utils.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {

    // Global Variables
    LoginPage loginPage;
    DashboardPage dashboardPage;

    String sheetName = "credentials";

    public LoginPageTest(){
        // Call TestBase class constructor which initializes all properties
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        loginPage = new LoginPage();
    }

    @DataProvider
    public Object[][] getOrangeHRMLoginData(){
        Object data[][] = TestUtil.getTestData(sheetName);
        return data;
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

    @Test(priority = 3, dataProvider="getOrangeHRMLoginData")
    public void loginTest(String username, String password) {
        //dashboardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        dashboardPage = loginPage.login(username, password);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
