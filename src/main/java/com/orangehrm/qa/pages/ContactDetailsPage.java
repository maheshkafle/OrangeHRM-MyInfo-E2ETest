package com.orangehrm.qa.pages;

import com.orangehrm.qa.base.TestBase;
import com.orangehrm.qa.utils.TestUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactDetailsPage extends TestBase {

    // Object Repo
    @FindBy(id = "btnSave")
    WebElement editSaveBtn;

    @FindBy(id = "contact_street1")
    WebElement Street1;

    @FindBy(id = "contact_street2")
    WebElement Street2;

    @FindBy(id = "contact_city")
    WebElement City;

    @FindBy(id = "contact_province")
    WebElement Province;

    @FindBy(id = "contact_emp_zipcode")
    WebElement PostalCode;

    @FindBy(id = "contact_emp_hm_telephone")
    WebElement HomeTelephone;

    @FindBy(id = "contact_emp_mobile")
    WebElement EmployeeMobileNo;

    @FindBy(id = "contact_emp_work_telephone")
    WebElement EmployeeWorkTelephoneNo;

    @FindBy(id = "contact_emp_work_email")
    WebElement EmployeeWorkEmail;

    @FindBy(id = "contact_emp_oth_email")
    WebElement EmployeeOtherEmail;

    @FindBy(className = "message")
    WebElement SuccessMessage;

    // Initializing Page Objects using constructor
    public ContactDetailsPage(){
        PageFactory.initElements(driver, this);
    }

    // Actions
    public void clickOnEditBtn(){
        editSaveBtn.click();
    }

    public void editStreet1(String street1){
        TestUtil.doSendKeys(Street1, street1);
    }

    public void editStreet2(String street2){
        TestUtil.doSendKeys(Street2, street2);
    }

    public void editCity(String city){
        TestUtil.doSendKeys(City, city);
    }

    public void editProvince(String province){
        TestUtil.doSendKeys(City, province);
    }

    public void editPostalCode(String postalcode){
        TestUtil.doSendKeys(PostalCode, postalcode);
    }

    public void editHomeTelephone(String hometelephone){
        TestUtil.doSendKeys(HomeTelephone, hometelephone);
    }

    public void editEmployeeMobileNo(String employeemobileno){
        TestUtil.doSendKeys(EmployeeMobileNo, employeemobileno);
    }

    public void editEmployeeWorkTelephoneNo(String employeeworktelephoneno){
        TestUtil.doSendKeys(EmployeeWorkTelephoneNo, employeeworktelephoneno);
    }

    public void editEmployeeWorkEmail(String employeeworkemail){
        TestUtil.doSendKeys(EmployeeWorkEmail, employeeworkemail);
    }

    public void editEmployeeOtherEmail(String employeeotheremail){
        TestUtil.doSendKeys(EmployeeOtherEmail, employeeotheremail);
    }

    public boolean isContactDetailsEdited(){
        System.out.println(SuccessMessage.getText());
        Boolean flag = SuccessMessage.isDisplayed();
        return flag;
    }

}
