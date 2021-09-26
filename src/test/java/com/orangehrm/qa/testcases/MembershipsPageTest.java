package com.orangehrm.qa.testcases;

import com.orangehrm.qa.base.TestBase;
import com.orangehrm.qa.pages.DashboardPage;
import com.orangehrm.qa.pages.LoginPage;
import com.orangehrm.qa.pages.MembershipsPage;
import com.orangehrm.qa.pages.PersonalDetailsPage;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MembershipsPageTest extends TestBase {


    PersonalDetailsPage personalDetailsPage;
    DashboardPage dashboardPage;
    LoginPage loginPage;
    MembershipsPage membershipsPage;

    public MembershipsPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
        personalDetailsPage = new PersonalDetailsPage();
        membershipsPage = new MembershipsPage();
        dashboardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        personalDetailsPage = dashboardPage.clickOnPersonalDetailsPageLink();
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        membershipsPage = personalDetailsPage.clickOnMembershipsPageLink();

    }

    @Test(priority = 1)
    public void verifyAddMembershipDetails() throws InterruptedException {
        for(int i=0; i<2; i++){
            membershipsPage.ClickBtnAddMembershipDetail();
            membershipsPage.AddMembership(prop.getProperty("valueMembership"));
            membershipsPage.AddSubscriptionPaidBy(prop.getProperty("valueSubscriptionPaidBy"));
            membershipsPage.AddSubscriptionAmount(prop.getProperty("valueSubscriptionAmount"));
            membershipsPage.AddMembershipCurrency(prop.getProperty("valueMembershipCurrency"));
            membershipsPage.AddSubscriptionCommenceDate(prop.getProperty("valueSubscriptionCommenceDate"));
            membershipsPage.AddSubscriptionRenewalDate(prop.getProperty("valueSubscriptionRenewalDate"));
            membershipsPage.ClickOnBtnSaveMembership();
            boolean flag = membershipsPage.IsMembershipsAdded();
            Assert.assertTrue(flag);
            Thread.sleep(3000);
        }
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
