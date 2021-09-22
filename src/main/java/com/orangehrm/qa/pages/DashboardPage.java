package com.orangehrm.qa.pages;

import com.orangehrm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class DashboardPage extends TestBase{

    @FindBy(xpath = "//h1[contains(text(), 'Dashboard')]")
    WebElement dashboardTitle;

    @FindBy(xpath = "//b[contains(text(), 'My Info')]")
    WebElement personalDetailsPageLink;

    // Initializing Page Objects using constructor
    public DashboardPage(){
        PageFactory.initElements(driver, this);
    }

    // Action
    public boolean validateDashboardLogo(){
        Boolean flag = dashboardTitle.isDisplayed();
        return flag;
    }

    public PersonalDetailsPage clickOnPersonalDetailsPageLink(){
        personalDetailsPageLink.click();
        return new PersonalDetailsPage();
    }


}
