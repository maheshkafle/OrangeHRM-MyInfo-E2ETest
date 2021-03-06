package com.orangehrm.qa.pages;

import com.orangehrm.qa.base.TestBase;
import com.orangehrm.qa.utils.TestUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmergencyContactsPage extends TestBase {

    @FindBy(id = "btnAddContact")
    WebElement BtnAddEmgContact;

    @FindBy(id = "btnSaveEContact")
    WebElement BtnSaveEmgContact;

    @FindBy(id = "emgcontacts_name")
    WebElement EmgContactsName;

    @FindBy(id = "emgcontacts_relationship")
    WebElement EmgContactsRelationship;

    @FindBy(id = "emgcontacts_homePhone")
    WebElement EmgContactsHomePhone;

    @FindBy(id = "emgcontacts_mobilePhone")
    WebElement EmgContactsMobilePhone;

    @FindBy(id = "emgcontacts_workPhone")
    WebElement EmgContactsWorkPhone;

    @FindBy(className = "message")
    WebElement CheckStatusDiv;

    //Hard coded xpath which contains text fd: So pass accordingly
    @FindBy(xpath = "//a[contains(text(), 'Preeyan Soudyal')]/parent::td//preceding-sibling::td//input[@class='checkbox']")
    WebElement Checkbox;

    @FindBy(id = "delContactsBtn")
    WebElement DelContactsBtn;

    // Initializing Page Objects using constructor
    public EmergencyContactsPage(){
        PageFactory.initElements(driver, this);
    }

    // Actions
    public void addEmergencyContacts() {
        BtnAddEmgContact.click();
    }

    public void addEmgContactsName() {
        TestUtil.doSendKeys(EmgContactsName, prop.getProperty("emgContactsName"));
    }

    public void addEmgContactsRelationship() {
        TestUtil.doSendKeys(EmgContactsRelationship, prop.getProperty("emgContactsRelationship"));
    }

    public void addEmgContactsHomePhone() {
        TestUtil.doSendKeys(EmgContactsHomePhone, prop.getProperty("emgContactsHomePhone"));
    }

    public void addEmgContactsMobilePhone() {
        TestUtil.doSendKeys(EmgContactsMobilePhone, prop.getProperty("emgContactsMobilePhone"));
    }

    public void addEmgContactsWorkPhone() {
        TestUtil.doSendKeys(EmgContactsWorkPhone, prop.getProperty("emgContactsWorkPhone"));
    }

    public void clickOnSaveBtn() {
        TestUtil.doClick(BtnSaveEmgContact);
    }

    public Boolean isEmgCtsDetailsAdded() {
        Boolean flag = TestUtil.checkStatus(CheckStatusDiv);
        return flag;
    }

    public void deleteEmergencyContacts() {
        TestUtil.doClick(Checkbox);
        TestUtil.doClick(DelContactsBtn);
    }

    public boolean isEmgCtsDetailsDeleted() {
        Boolean flag = TestUtil.checkStatus(CheckStatusDiv);
        return flag;
    }
}
