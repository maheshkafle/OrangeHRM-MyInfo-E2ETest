package com.orangehrm.qa.testcases;

import com.orangehrm.qa.base.TestBase;
import com.orangehrm.qa.pages.DashboardPage;
import com.orangehrm.qa.pages.LoginPage;
import com.orangehrm.qa.pages.PersonalDetailsPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PersonalDetailsPageTest extends TestBase {

    PersonalDetailsPage personalDetailsPage;
    DashboardPage dashboardPage;
    LoginPage loginPage;

    public PersonalDetailsPageTest(){
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
    public void verifyEditPersonalDetails() throws InterruptedException {
        personalDetailsPage.clickOnEditBtn();
        personalDetailsPage.editFirstName(prop.getProperty("firstName"));
        personalDetailsPage.editMiddleName(prop.getProperty("middleName"));
        personalDetailsPage.editLastName(prop.getProperty("lastName"));
        personalDetailsPage.clickGenderRadioBtn();
        personalDetailsPage.selectLicenseExpiryDate();
        personalDetailsPage.selectMaritalStatus();
        personalDetailsPage.clickOnEditBtn();
        Boolean flag = personalDetailsPage.isPersonalDetailsEdited();
        System.out.println("flag");
        Assert.assertTrue(flag);
        Thread.sleep(2000);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}
