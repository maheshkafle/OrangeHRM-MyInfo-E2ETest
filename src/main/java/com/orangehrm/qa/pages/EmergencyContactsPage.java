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


    // Initializing Page Objects using constructor
    public EmergencyContactsPage(){
        PageFactory.initElements(driver, this);
    }

    // Actions
    public void addEmergencyContacts() throws InterruptedException {
        BtnAddEmgContact.click();
        Thread.sleep(3000);
    }

    public void addEmgContactsName() throws InterruptedException {
        TestUtil.doSendKeys(EmgContactsName, prop.getProperty("emgContactsName"));
        Thread.sleep(3000);
    }

    public void addEmgContactsRelationship() throws InterruptedException {
        TestUtil.doSendKeys(EmgContactsRelationship, prop.getProperty("emgContactsRelationship"));
        Thread.sleep(3000);
    }

    public void addEmgContactsHomePhone() throws InterruptedException {
        TestUtil.doSendKeys(EmgContactsHomePhone, prop.getProperty("emgContactsHomePhone"));
        Thread.sleep(3000);
    }

    public void addEmgContactsMobilePhone() throws InterruptedException {
        TestUtil.doSendKeys(EmgContactsMobilePhone, prop.getProperty("emgContactsMobilePhone"));
        Thread.sleep(3000);
    }

    public void addEmgContactsWorkPhone() throws InterruptedException {
        TestUtil.doSendKeys(EmgContactsWorkPhone, prop.getProperty("emgContactsWorkPhone"));
        Thread.sleep(3000);
    }

    public void clickOnSaveBtn() throws InterruptedException {
        TestUtil.doClick(BtnSaveEmgContact);
        Thread.sleep(3000);
    }


}
