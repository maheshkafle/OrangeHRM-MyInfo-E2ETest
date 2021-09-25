package com.orangehrm.qa.pages;

import com.orangehrm.qa.base.TestBase;
import com.orangehrm.qa.utils.TestUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ImmigrationPage extends TestBase {

    // Object Repo
    @FindBy(id = "btnAdd")
    WebElement BtnAddImmigrants;

    @FindBy(id = "btnSave")
    WebElement BtnSaveImmigrants;

    @FindBy(id = "immigration_type_flag_2")
    WebElement Visa;

    @FindBy(id = "immigration_number")
    WebElement ImmigrationNumber;

    @FindBy(id = "immigration_passport_issue_date")
    WebElement PassportIssueDate;

    @FindBy(id = "immigration_passport_expire_date")
    WebElement PassportExpireDate;

    @FindBy(id = "immigration_i9_status")
    WebElement ImmigrationStatus;

    @FindBy(id = "immigration_country")
    WebElement IssuedBy;

    @FindBy(id = "immigration_i9_review_date")
    WebElement ReviewDate;

    @FindBy(id = "immigration_comments")
    WebElement Comments;

    @FindBy(className = "message")
    WebElement CheckStatusDiv;

//    @FindBy(id = "delDependentBtn")
//    WebElement DelDependentBtn;

    // Initializing Page Objects using constructor
    public ImmigrationPage(){
        PageFactory.initElements(driver, this);
    }

    public void clickAddImmigrantBtn(){
        TestUtil.doClick(BtnAddImmigrants);
    }

    public void clickDocumentCheckbox(){
        TestUtil.doClick(Visa);
    }

    public void AddImmigrationNumber(String immigrationNumber){
        TestUtil.doSendKeys(ImmigrationNumber, immigrationNumber);
    }

    public void AddPassportIssueDate(String passportIssueDate) throws InterruptedException {
        TestUtil.SelectDateFromCalenderCustom(driver, PassportIssueDate, passportIssueDate);
    }

    public void AddPassportExpireDate(String passportExpireDate) throws InterruptedException {
        TestUtil.SelectDateFromCalenderCustom(driver, PassportExpireDate, passportExpireDate);
    }

    public void AddImmigrationStatus(String immigrationStatus){
        TestUtil.doSendKeys(ImmigrationStatus, immigrationStatus);
    }

    public void AddIssuedBy(String issuedBy) throws InterruptedException {
        TestUtil.selectDropdownValue(IssuedBy, issuedBy);
    }

    public void AddPassportReviewDate(String reviewDate) throws InterruptedException {
        TestUtil.SelectDateFromCalenderCustom(driver, ReviewDate, reviewDate);
    }

    public void AddComments(String comments){
        TestUtil.doSendKeys(Comments, comments);
    }

    public void clickSaveImmigrantBtn(){
        TestUtil.doClick(BtnSaveImmigrants);
    }

    public boolean isImmigrantsAdded() {
        Boolean flag = TestUtil.checkStatus(CheckStatusDiv);
        return flag;
    }

//    public void deleteDependents() {
//        TestUtil.doClick(Checkbox);
//        TestUtil.doClick(DelDependentBtn);
//    }
//
//    public boolean isDependentsDeleted() {
//        Boolean flag = TestUtil.checkStatus(CheckStatusDiv);
//        return flag;
//    }
}
