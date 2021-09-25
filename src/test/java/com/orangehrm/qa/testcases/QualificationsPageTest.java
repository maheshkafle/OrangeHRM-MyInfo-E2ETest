package com.orangehrm.qa.testcases;

import com.orangehrm.qa.base.TestBase;
import com.orangehrm.qa.pages.DashboardPage;
import com.orangehrm.qa.pages.LoginPage;
import com.orangehrm.qa.pages.PersonalDetailsPage;
import com.orangehrm.qa.pages.QualificationsPage;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class QualificationsPageTest extends TestBase {

    PersonalDetailsPage personalDetailsPage;
    DashboardPage dashboardPage;
    LoginPage loginPage;
    QualificationsPage qualificationsPage;

    public QualificationsPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
        personalDetailsPage = new PersonalDetailsPage();
        qualificationsPage = new QualificationsPage();
        dashboardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        personalDetailsPage = dashboardPage.clickOnPersonalDetailsPageLink();
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        qualificationsPage = personalDetailsPage.clickOnQualificationsPageLink();
    }

    @Test(priority = 1)
    public void verifyAddWorkExperience() throws InterruptedException {
        qualificationsPage.clickAddWorkExperienceBtn();
        qualificationsPage.AddCompany(prop.getProperty("company"));
        qualificationsPage.AddJobTitle(prop.getProperty("jobTitle"));
        qualificationsPage.AddJobStartDate(prop.getProperty("jobStartDate"));
        qualificationsPage.AddJobEndDate(prop.getProperty("JobEndDate"));
        qualificationsPage.AddComments(prop.getProperty("workExpComments"));
        qualificationsPage.clickSaveWorkExperienceBtn();
        Boolean flag = qualificationsPage.isWorkExperienceAdded();
        Assert.assertTrue(flag);
        Thread.sleep(3000);
    }

    @Test(priority = 2)
    public void verifyDeleteImmigrants() throws InterruptedException {
        for(int i=0; i<2; i++){
            qualificationsPage.deleteWorkExperience();
            Boolean flag = qualificationsPage.isWorkExperienceDeleted();
            Assert.assertTrue(flag);
            Thread.sleep(3000);
        }
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
