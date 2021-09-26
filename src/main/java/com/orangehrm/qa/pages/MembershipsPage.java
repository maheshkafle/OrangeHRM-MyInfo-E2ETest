package com.orangehrm.qa.pages;

import com.orangehrm.qa.base.TestBase;
import com.orangehrm.qa.utils.TestUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MembershipsPage extends TestBase {

    @FindBy(id = "btnAddMembershipDetail")
    WebElement BtnAddMembershipDetail;

    @FindBy(id = "membership_membership")
    WebElement Membership;

    @FindBy(id = "membership_subscriptionPaidBy")
    WebElement SubscriptionPaidBy;

    @FindBy(id = "membership_subscriptionAmount")
    WebElement SubscriptionAmount;

    @FindBy(id = "membership_currency")
    WebElement MembershipCurrency;

    @FindBy(id = "membership_subscriptionCommenceDate")
    WebElement SubscriptionCommenceDate;

    @FindBy(id = "membership_subscriptionRenewalDate")
    WebElement SubscriptionRenewalDate;

    @FindBy(id = "btnSaveMembership")
    WebElement BtnSaveMembership;

    @FindBy(className = "message")
    WebElement CheckStatusDiv;

    @FindBy(id = "btnAddAttachment")
    WebElement BtnAddAttachment;

    @FindBy(id = "ufile")
    WebElement BtnUpload;

    @FindBy(id = "btnSaveAttachment")
    WebElement BtnSaveAttachment;

    //Hard coded xpath which contains text British Computer Society (BCS): So pass accordingly
    @FindBy(xpath = "//a[contains(text(), \"British Computer Society (BCS)\")]/parent::td//preceding-sibling::td//input[@class='checkboxMem']")
    WebElement MembershipCheckbox;

    @FindBy(id = "delMemsBtn")
    WebElement BtnDelMembership;

    // Initializing Page Objects using constructor
    public MembershipsPage(){
        PageFactory.initElements(driver, this);
    }

    public void ClickBtnAddMembershipDetail(){
        TestUtil.doClick(BtnAddMembershipDetail);
    }

    public void AddMembership(String valueMembership) throws InterruptedException {
        TestUtil.selectDropdownValue(Membership, valueMembership);
    }

    public void AddSubscriptionPaidBy(String valueSubscriptionPaidBy) throws InterruptedException {
        TestUtil.selectDropdownValue(SubscriptionPaidBy, valueSubscriptionPaidBy);
    }

    public void AddSubscriptionAmount(String valueSubscriptionAmount) throws InterruptedException {
        TestUtil.doSendKeys(SubscriptionAmount, valueSubscriptionAmount);
    }

    public void AddMembershipCurrency(String valueMembershipCurrency) throws InterruptedException {
        TestUtil.selectDropdownValue(MembershipCurrency, valueMembershipCurrency);
    }

    public void AddSubscriptionCommenceDate(String valueSubscriptionCommenceDate) throws InterruptedException {
        TestUtil.SelectDateFromCalenderCustom(driver, SubscriptionCommenceDate, valueSubscriptionCommenceDate);
    }

    public void AddSubscriptionRenewalDate(String valueSubscriptionRenewalDate) throws InterruptedException {
        TestUtil.SelectDateFromCalenderCustom(driver, SubscriptionRenewalDate, valueSubscriptionRenewalDate);
    }

    public void ClickOnBtnSaveMembership(){
        TestUtil.doClick(BtnSaveMembership);
    }

    public boolean IsMembershipsAdded(){
        System.out.println(CheckStatusDiv.getText());
        Boolean flag = TestUtil.checkStatus(CheckStatusDiv);
        return flag;
    }

    public void uploadMembershipAttach(){
        TestUtil.uploadAttachment(BtnAddAttachment, BtnUpload, BtnSaveAttachment, prop.getProperty("pathToMembershipAttachment"));
    }

    public boolean IsMembershipAttachUploaded(){
        System.out.println(CheckStatusDiv.getText());
        Boolean flag = TestUtil.checkStatus(CheckStatusDiv);
        return flag;
    }

    public void DeleteMembershipDetails() {
        TestUtil.doClick(MembershipCheckbox);
        TestUtil.doClick(BtnDelMembership);
    }

    public boolean IsMembershipDetailsDeleted() {
        Boolean flag = TestUtil.checkStatus(CheckStatusDiv);
        return flag;
    }
}
