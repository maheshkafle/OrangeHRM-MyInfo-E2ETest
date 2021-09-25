package com.orangehrm.qa.pages;

import com.orangehrm.qa.base.TestBase;
import com.orangehrm.qa.utils.TestUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QualificationsPage extends TestBase {

    // Object Repo
    @FindBy(id = "addWorkExperience")
    WebElement BtnAddWorkExperience;

    @FindBy(id = "btnWorkExpSave")
    WebElement BtnSaveWorkExperience;

    @FindBy(id = "experience_employer")
    WebElement Company;

    @FindBy(id = "experience_jobtitle")
    WebElement JobTitle;

    @FindBy(id = "experience_from_date")
    WebElement JobStartDate;

    @FindBy(id = "experience_to_date")
    WebElement JobEndDate;

    @FindBy(id = "experience_comments")
    WebElement Comments;

    @FindBy(className = "message")
    WebElement CheckStatusDiv;

    //Hard coded xpath which contains text shi:dolutions: So pass accordingly
    @FindBy(xpath = "//a[contains(text(), 'shi:dolutions')]/parent::td//preceding-sibling::td//input[@name='delWorkExp[]']")
    WebElement WorkExpCheckbox;

    @FindBy(id = "delWorkExperience")
    WebElement BtndelWorkExperience;

    // Initializing Page Objects using constructor
    public QualificationsPage(){
        PageFactory.initElements(driver, this);
    }

    public void clickAddWorkExperienceBtn(){
        TestUtil.doClick(BtnAddWorkExperience);
    }

    public void AddCompany(String company){
        TestUtil.doSendKeys(Company, company);
    }

    public void AddJobTitle(String jobTitle) throws InterruptedException {
        TestUtil.doSendKeys(JobTitle, jobTitle);
    }

    public void AddJobStartDate(String jobStartDate) throws InterruptedException {
        TestUtil.SelectDateFromCalenderCustom(driver, JobStartDate, jobStartDate);
    }

    public void AddJobEndDate(String jobEndDate) throws InterruptedException {
        TestUtil.SelectDateFromCalenderCustom(driver, JobEndDate, jobEndDate);
    }


    public void AddComments(String comments){
        TestUtil.doSendKeys(Comments, comments);
    }

    public void clickSaveWorkExperienceBtn(){
        TestUtil.doClick(BtnSaveWorkExperience);
    }

    public boolean isWorkExperienceAdded() {
        Boolean flag = TestUtil.checkStatus(CheckStatusDiv);
        return flag;
    }

    public void deleteWorkExperience() {
        TestUtil.doClick(WorkExpCheckbox);
        TestUtil.doClick(BtndelWorkExperience);
    }

    public boolean isWorkExperienceDeleted() {
        Boolean flag = TestUtil.checkStatus(CheckStatusDiv);
        return flag;
    }

}
