package com.orangehrm.qa.pages;

import com.orangehrm.qa.base.TestBase;
import com.orangehrm.qa.utils.TestUtil;
import org.bson.assertions.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class PersonalDetailsPage extends TestBase {

    @FindBy(xpath = "//a[contains(text(), 'Contact Details')]")
    WebElement ContactDetailsPageLink;

    @FindBy(xpath = "//a[contains(text(), 'Emergency Contacts')]")
    WebElement EmergencyContactsPageLink;

    @FindBy(xpath = "//a[contains(text(), 'Dependents')]")
    WebElement DependentsPageLink;

    @FindBy(xpath = "//a[contains(text(), 'Immigration')]")
    WebElement ImmigrationPageLink;

    @FindBy(xpath = "//a[contains(text(), 'Salary')]")
    WebElement SalaryPageLink;

    @FindBy(xpath = "//a[contains(text(), 'Report-to')]")
    WebElement ReportToPageLink;

    @FindBy(id = "btnSave")
    WebElement editSaveBtn;

    @FindBy(id = "personal_txtEmpFirstName")
    WebElement FirstName;

    @FindBy(id = "personal_txtEmpMiddleName")
    WebElement MiddleName;

    @FindBy(id = "personal_txtEmpLastName")
    WebElement LastName;

    @FindBy(id = "personal_optGender_2")
    WebElement FemaleRadioBtn;

    @FindBy(id = "personal_txtLicExpDate")
    WebElement LicenseExpiryDate;

    @FindBy(id = "personal_cmbMarital")
    WebElement MaritalStatus;

    @FindBy(className = "message")
    WebElement SuccessMessage;

    @FindBy(id = "empPic")
    WebElement EmployeePic;

    @FindBy(id = "photofile")
    WebElement browse;

    @FindBy(xpath = "//input[contains(@value,'Upload')]")
    WebElement uploadBtn;

    // Initializing Page Objects using constructor
    public PersonalDetailsPage(){
        PageFactory.initElements(driver, this);
    }

    // Action
    public ContactDetailsPage clickOnContactDetailsPageLink(){
        ContactDetailsPageLink.click();
        return new ContactDetailsPage();
    }

    public EmergencyContactsPage clickOnEmergencyContactsPageLink(){
        EmergencyContactsPageLink.click();
        return new EmergencyContactsPage();
    }

    public DependentsPage clickOnDependentsPageLink(){
        DependentsPageLink.click();
        return new DependentsPage();
    }

    public ImmigrationPage clickOnImmigrationPageLink(){
        ImmigrationPageLink.click();
        return new ImmigrationPage();
    }

    public JobPage clickOnJobPageLink(){
        ArrayList<WebElement> JobLinks = (ArrayList<WebElement>) driver.findElements(By.xpath("//a[contains(text(), 'Job')]"));
        for(int j=0; j<JobLinks.size(); j++){
            System.out.println(JobLinks.get(j).getText());
            String JobText = JobLinks.get(j).getText();
            if(JobText.equals("Job")){
                JobLinks.get(j).click();
                break;
            }
        }
        return new JobPage();
    }

    public SalaryPage clickOnSalaryPageLink(){
        SalaryPageLink.click();
        return new SalaryPage();
    }

    public ReportsToPage clickOnReportToPageLink(){
        ReportToPageLink.click();
        return new ReportsToPage();
    }

    public QualificationsPage clickOnQualificationsPageLink(){
        ArrayList<WebElement> QualificationsLinks = (ArrayList<WebElement>) driver.findElements(By.xpath("//a[contains(text(), 'Qualifications')]"));
        for(int j=0; j<QualificationsLinks.size(); j++){
            System.out.println(QualificationsLinks.get(j).getText());
            String JobText = QualificationsLinks.get(j).getText();
            if(JobText.equals("Qualifications")){
                QualificationsLinks.get(j).click();
                break;
            }
        }
        return new QualificationsPage();
    }

    public MembershipsPage clickOnMembershipsPageLink(){
        ArrayList<WebElement> MembershipsLinks = (ArrayList<WebElement>) driver.findElements(By.xpath("//a[contains(text(), 'Memberships')]"));
        for(int j=0; j<MembershipsLinks.size(); j++){
            System.out.println(MembershipsLinks.get(j).getText());
            String JobText = MembershipsLinks.get(j).getText();
            if(JobText.equals("Memberships")){
                MembershipsLinks.get(j).click();
                break;
            }
        }
        return new MembershipsPage();
    }

    public void clickOnEditBtn(){
        editSaveBtn.click();
    }

    public void editFirstName(String firstName){
        TestUtil.doSendKeys(FirstName, firstName);
    }

    public void editMiddleName(String middleName){
        TestUtil.doSendKeys(MiddleName, middleName);
    }

    public void editLastName(String lastName){
        TestUtil.doSendKeys(LastName, lastName);
    }

    public void clickGenderRadioBtn(){
        TestUtil.doClickRadioBtn(FemaleRadioBtn);
    }

    public void selectLicenseExpiryDate() throws InterruptedException {
        String licenseExpiryDate = prop.getProperty("licenseExpiryDate");
        TestUtil.SelectDateFromCalenderCustom(driver, LicenseExpiryDate, licenseExpiryDate);
    }

    public void selectMaritalStatus() throws InterruptedException {
        String maritalStatus = prop.getProperty("maritalStatus");
        TestUtil.selectDropdownValue(MaritalStatus, maritalStatus);
    }

    public boolean isPersonalDetailsEdited(){
        System.out.println(SuccessMessage.getText());
        Boolean flag = SuccessMessage.isDisplayed();
        return flag;
    }

    public void uploadEmployeeProfilePic(){
        EmployeePic.click();
        String path = prop.getProperty("pathToEmployeePic"); // "src\\main\\resources\\jepg.jpeg"
        browse.sendKeys(path);
        uploadBtn.click();
    }

    public boolean isEmployeePicUploaded(){
        System.out.println(SuccessMessage.getText());
        Boolean flag = SuccessMessage.isDisplayed();
        return flag;
    }
}
