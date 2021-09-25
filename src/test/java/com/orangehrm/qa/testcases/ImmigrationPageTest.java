package com.orangehrm.qa.testcases;

import com.orangehrm.qa.base.TestBase;
import com.orangehrm.qa.pages.DashboardPage;
import com.orangehrm.qa.pages.ImmigrationPage;
import com.orangehrm.qa.pages.LoginPage;
import com.orangehrm.qa.pages.PersonalDetailsPage;
import org.apache.poi.ss.formula.functions.T;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ImmigrationPageTest extends TestBase {

    PersonalDetailsPage personalDetailsPage;
    DashboardPage dashboardPage;
    LoginPage loginPage;
    ImmigrationPage immigrationPage;

    public ImmigrationPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
        personalDetailsPage = new PersonalDetailsPage();
        immigrationPage = new ImmigrationPage();
        dashboardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        personalDetailsPage = dashboardPage.clickOnPersonalDetailsPageLink();
        immigrationPage = personalDetailsPage.clickOnImmigrationPageLink();
    }

    @Test(priority = 1)
    public void verifyAddImmigrationDetails() throws InterruptedException {
        for (int i=0; i<2; i++){
            immigrationPage.clickAddImmigrantBtn();
            immigrationPage.clickDocumentCheckbox();
            immigrationPage.AddImmigrationNumber(prop.getProperty("immigrationNumber"));
            immigrationPage.AddPassportIssueDate(prop.getProperty("passportIssueDate"));
            immigrationPage.AddPassportExpireDate(prop.getProperty("passportExpireDate"));
            immigrationPage.AddImmigrationStatus(prop.getProperty("immigrationStatus"));
            immigrationPage.AddIssuedBy(prop.getProperty("issuedBy"));
            immigrationPage.AddPassportReviewDate(prop.getProperty("reviewDate"));
            immigrationPage.AddComments(prop.getProperty("comments"));
            immigrationPage.clickSaveImmigrantBtn();
            Boolean flag = immigrationPage.isImmigrantsAdded();
            Assert.assertTrue(flag);
            Thread.sleep(3000);
        }
    }

    @Test(priority = 2)
    public void verifyDeleteImmigrants() throws InterruptedException {
        for(int i=0; i<2; i++){
            immigrationPage.deleteImmigrants();
            Boolean flag = immigrationPage.isImmigrantsDeleted();
            Assert.assertTrue(flag);
            Thread.sleep(3000);
        }
    }

    @Test(priority = 3)
    public void verifyUploadAttachRecords() throws InterruptedException {
        for(int i=0; i<2; i++){
            immigrationPage.attachImmigrantRecord();
            Boolean flag = immigrationPage.isImmigrantRecordAttached();
            Assert.assertTrue(flag);
            Thread.sleep(3000);
        }
    }

    @Test(priority = 4)
    public void verifyDeleteImmigrantAttachmentRecord() throws InterruptedException {
        for(int i=0; i<2; i++){
            immigrationPage.DeleteImmigrantAttachmentRecord();
            Boolean flag = immigrationPage.isImmigrantAttachmentRecordDeleted();
            Assert.assertTrue(flag);
            Thread.sleep(3000);
        }
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
