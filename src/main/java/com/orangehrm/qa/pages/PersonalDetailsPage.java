package com.orangehrm.qa.pages;

import com.orangehrm.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PersonalDetailsPage extends TestBase {

    @FindBy(xpath = "//a[contains(text(), 'Contact Details')]")
    WebElement ContactDetailsPageLink;

    @FindBy(xpath = "//a[contains(text(), 'Emergency Contacts')]")
    WebElement EmergencyContactsPageLink;

    @FindBy(xpath = "//a[contains(text(), 'Dependents')]")
    WebElement DependentsPageLink;

    @FindBy(xpath = "//a[contains(text(), 'Immigration')]")
    WebElement ImmigrationPageLink;

    @FindBy(xpath = "//a[contains(text(), 'Job')]")
    WebElement JobPageLink;

    @FindBy(xpath = "//a[contains(text(), 'Salary')]")
    WebElement SalaryPageLink;

    @FindBy(xpath = "//a[contains(text(), 'Report-to')]")
    WebElement ReportToPageLink;

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
        JobPageLink.click();
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

}
