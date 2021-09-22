package com.orangehrm.qa.pages;

import com.orangehrm.qa.base.TestBase;
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

//    @FindBy(xpath = "//a[contains(text(), 'Job')]")
//    We JobPageLinks;

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

}
