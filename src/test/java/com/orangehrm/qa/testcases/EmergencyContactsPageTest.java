package com.orangehrm.qa.testcases;

import com.orangehrm.qa.base.TestBase;
import com.orangehrm.qa.pages.DashboardPage;
import com.orangehrm.qa.pages.EmergencyContactsPage;
import com.orangehrm.qa.pages.LoginPage;
import com.orangehrm.qa.pages.PersonalDetailsPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EmergencyContactsPageTest extends TestBase {

    PersonalDetailsPage personalDetailsPage;
    DashboardPage dashboardPage;
    LoginPage loginPage;
    EmergencyContactsPage emergencyContactsPage;

    public EmergencyContactsPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
        personalDetailsPage = new PersonalDetailsPage();
        emergencyContactsPage = new EmergencyContactsPage();
        dashboardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        personalDetailsPage = dashboardPage.clickOnPersonalDetailsPageLink();
        emergencyContactsPage = personalDetailsPage.clickOnEmergencyContactsPageLink();
    }

    @Test(priority = 1)
    public void verifyAddEmergencyContacts() throws InterruptedException {
        for(int i=0; i<2; i++){
            emergencyContactsPage.addEmergencyContacts();
            emergencyContactsPage.addEmgContactsName();
            emergencyContactsPage.addEmgContactsRelationship();
            emergencyContactsPage.addEmgContactsHomePhone();
            emergencyContactsPage.addEmgContactsMobilePhone();
            emergencyContactsPage.addEmgContactsWorkPhone();
            emergencyContactsPage.clickOnSaveBtn();
            Boolean flag = emergencyContactsPage.isEmgCtsDetailsAdded();
            Assert.assertTrue(flag);
            Thread.sleep(3000);
        }
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
