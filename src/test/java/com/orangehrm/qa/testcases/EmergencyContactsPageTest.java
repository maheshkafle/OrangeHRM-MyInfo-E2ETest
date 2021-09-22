package com.orangehrm.qa.testcases;

import com.orangehrm.qa.base.TestBase;
import com.orangehrm.qa.pages.DashboardPage;
import com.orangehrm.qa.pages.LoginPage;
import com.orangehrm.qa.pages.PersonalDetailsPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EmergencyContactsPageTest extends TestBase {

    PersonalDetailsPage personalDetailsPage;
    DashboardPage dashboardPage;
    LoginPage loginPage;

    public EmergencyContactsPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
        personalDetailsPage = new PersonalDetailsPage();
        dashboardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        personalDetailsPage = dashboardPage.clickOnPersonalDetailsPageLink();
    }

    @Test(priority = 1)
    public void verifyNavigateToEmergencyContactsPage(){
        personalDetailsPage.clickOnEmergencyContactsPageLink();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
