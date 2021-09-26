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
    public void verifyDeleteWorkExperience() throws InterruptedException {
        qualificationsPage.deleteWorkExperience();
        Boolean flag = qualificationsPage.isWorkExperienceDeleted();
        Assert.assertTrue(flag);
        Thread.sleep(3000);
    }

    @Test(priority = 3)
    public void verifyAddEducation() throws InterruptedException {
        qualificationsPage.clickAddEducationBtn();
        qualificationsPage.selectEducationLevel(prop.getProperty("valueEducationLevel"));
        qualificationsPage.AddEducationInstitute(prop.getProperty("valueEducationInstitute"));
        qualificationsPage.AddEducationSpecialization(prop.getProperty("valueEducationSpecialization"));
        qualificationsPage.AddEducationYear(prop.getProperty("valueEducationYear"));
        qualificationsPage.AddEducationGPA(prop.getProperty("valueEducationGPA"));
        qualificationsPage.AddEducationStartDate(prop.getProperty("valueEducationStartDate"));
        qualificationsPage.AddEducationEndDate(prop.getProperty("valueEducationEndDate"));
        qualificationsPage.clickSaveEducationBtn();
        Boolean flag = qualificationsPage.isEducationAdded();
        Assert.assertTrue(flag);
        Thread.sleep(3000);
    }

    @Test(priority = 4)
    public void verifyAddSkills() throws InterruptedException {
        qualificationsPage.clickAddSkillBtn();
        qualificationsPage.selectSkill(prop.getProperty("valueSkill"));
        qualificationsPage.AddYearsOfExperience(prop.getProperty("valueYearsOfExperience"));
        qualificationsPage.AddSkillComments(prop.getProperty("valueSkillComments"));
        qualificationsPage.clickBtnSkillSave();
        Boolean flag = qualificationsPage.isSkillAdded();
        Assert.assertTrue(flag);
        Thread.sleep(3000);
    }

    @Test(priority = 5)
    public void verifyDeleteSkills() throws InterruptedException {
        qualificationsPage.DeleteSkills();
        Boolean flag = qualificationsPage.IsSkillsDeleted();
        Assert.assertTrue(flag);
        Thread.sleep(3000);
    }

    @Test(priority = 6)
    public void verifyAddLanguages() throws InterruptedException {
        qualificationsPage.clickAddLanguageBtn();
        qualificationsPage.selectLanguage(prop.getProperty("valueLanguage"));
        qualificationsPage.selectLanguageType(prop.getProperty("valueLanguageType"));
        qualificationsPage.selectLanguageCompetency(prop.getProperty("valueLanguageCompetency"));
        qualificationsPage.AddLanguageComments(prop.getProperty("valueLanguageComments"));
        qualificationsPage.clickBtnLanguageSave();
        Boolean flag = qualificationsPage.isLanguageAdded();
        Assert.assertTrue(flag);
        Thread.sleep(3000);
    }

    @Test(priority = 7)
    public void verifyAddLicense() throws InterruptedException {
        qualificationsPage.ClickBtnAddLicense();
        qualificationsPage.AddLicenseType(prop.getProperty("valueLicenseType"));
        qualificationsPage.AddLicenseNumber(prop.getProperty("valueLicenseNumber"));
        qualificationsPage.AddLicenseIssueDate(prop.getProperty("valueLicenseIssueDate"));
        qualificationsPage.AddLicenseRenewalDate(prop.getProperty("valueLicenseRenewalDate"));
        qualificationsPage.ClickBtnLicenseSave();
        Boolean flag = qualificationsPage.IsLicenseAdded();
        Assert.assertTrue(flag);
        Thread.sleep(3000);
    }

    @Test(priority = 8)
    public void verifyUploadQualificationAttach(){
        qualificationsPage.uploadQualificationAttach();
        Boolean flag = qualificationsPage.isQualificationAttachUploaded();
        Assert.assertTrue(flag);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
