package com.orangehrm.qa.testcases;

import com.orangehrm.qa.base.TestBase;
import com.orangehrm.qa.pages.ContactDetailsPage;
import com.orangehrm.qa.pages.DashboardPage;
import com.orangehrm.qa.pages.LoginPage;
import com.orangehrm.qa.pages.PersonalDetailsPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactDetailsPageTest extends TestBase {

    PersonalDetailsPage personalDetailsPage;
    DashboardPage dashboardPage;
    LoginPage loginPage;
    ContactDetailsPage contactDetailsPage;

    public ContactDetailsPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
        personalDetailsPage = new PersonalDetailsPage();
        contactDetailsPage = new ContactDetailsPage();
        dashboardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        personalDetailsPage = dashboardPage.clickOnPersonalDetailsPageLink();
        contactDetailsPage = personalDetailsPage.clickOnContactDetailsPageLink();
    }

    @Test(priority = 1)
    public void verifyEditContactDetails() throws InterruptedException {
        contactDetailsPage.clickOnEditBtn();
        contactDetailsPage.editStreet1(prop.getProperty("street1"));
        contactDetailsPage.editStreet2(prop.getProperty("street2"));
        contactDetailsPage.editCity(prop.getProperty("city"));
        contactDetailsPage.editProvince(prop.getProperty("province"));
        contactDetailsPage.editPostalCode(prop.getProperty("postalcode"));
        contactDetailsPage.editHomeTelephone(prop.getProperty("hometelephone"));
        contactDetailsPage.editEmployeeMobileNo(prop.getProperty("employeemobileno"));
        contactDetailsPage.editEmployeeWorkTelephoneNo(prop.getProperty("employeeworktelephoneno"));
        contactDetailsPage.editEmployeeWorkEmail(prop.getProperty("employeeworkemail"));
        contactDetailsPage.editEmployeeOtherEmail(prop.getProperty("employeeotheremail"));
        contactDetailsPage.clickOnEditBtn();
        Boolean flag = contactDetailsPage.isContactDetailsEdited();
        Assert.assertTrue(flag);
        Thread.sleep(2000);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
