package com.orangehrm.qa.testcases;

import com.orangehrm.qa.base.TestBase;
import com.orangehrm.qa.pages.DashboardPage;
import com.orangehrm.qa.pages.DependentsPage;
import com.orangehrm.qa.pages.LoginPage;
import com.orangehrm.qa.pages.PersonalDetailsPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DependentsPageTest extends TestBase {

    PersonalDetailsPage personalDetailsPage;
    DashboardPage dashboardPage;
    LoginPage loginPage;
    DependentsPage dependentsPage;

    public DependentsPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
        dependentsPage = new DependentsPage();
        personalDetailsPage = new PersonalDetailsPage();
        dashboardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        personalDetailsPage = dashboardPage.clickOnPersonalDetailsPageLink();
        dependentsPage = personalDetailsPage.clickOnDependentsPageLink();
    }

    @Test(priority = 1)
    public void verifyAddDependents() throws InterruptedException {
        for (int i =0; i<2; i++){
            dependentsPage.clickOnAddDependentBtn();
            dependentsPage.AddDependentName(prop.getProperty("dependentName"));
            dependentsPage.AddDependentRelationshipType(prop.getProperty("dependentRelationshipType"), prop.getProperty("dependentRelationship"));
            dependentsPage.AddDependentDateOfBirth(prop.getProperty("dependentDateOfBirth"));
            dependentsPage.clickOnSaveDependentBtn();
            Boolean flag = dependentsPage.isDependentsAdded();
            Assert.assertTrue(flag);
            Thread.sleep(3000);
        }
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
