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

    //Hard coded xpath which contains text Visa: So pass accordingly
    @FindBy(xpath = "//a[contains(text(), 'Visa')]/parent::td//preceding-sibling::td//input[@class='checkbox']")
    WebElement VisaCheckbox;

    //Hard coded xpath which contains text png.png: So pass accordingly
    @FindBy(xpath = "//a[contains(text(), 'png.png')]/parent::td//preceding-sibling::td//input[@class='checkboxAtch']")
    WebElement AttachmentCheckbox;

    @FindBy(id = "btnDelete")
    WebElement DelImmigrantBtn;

    @FindBy(id = "btnAddAttachment")
    WebElement BtnAddAttachment;

    @FindBy(id = "ufile")
    WebElement BtnUploadAttachment;

    @FindBy(id = "btnSaveAttachment")
    WebElement BtnSaveAttachment;

    @FindBy(id = "btnDeleteAttachment")
    WebElement BtnDeleteAttachment;

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

    public void deleteImmigrants() {
        TestUtil.doClick(VisaCheckbox);
        TestUtil.doClick(DelImmigrantBtn);
    }

    public boolean isImmigrantsDeleted() {
        Boolean flag = TestUtil.checkStatus(CheckStatusDiv);
        return flag;
    }

    public void attachImmigrantRecord() {
        TestUtil.uploadAttachment(BtnAddAttachment, BtnUploadAttachment, BtnSaveAttachment, prop.getProperty("pathToImmigrantRecordAttachment"));
    }

    public Boolean isImmigrantRecordAttached(){
        System.out.println(CheckStatusDiv.getText());
        Boolean flag = TestUtil.checkStatus(CheckStatusDiv);
        return flag;
    }

    public void DeleteImmigrantAttachmentRecord() {
        TestUtil.doClick(AttachmentCheckbox);
        TestUtil.doClick(BtnDeleteAttachment);
    }

    public boolean isImmigrantAttachmentRecordDeleted() {
        Boolean flag = TestUtil.checkStatus(CheckStatusDiv);
        return flag;
    }

}
