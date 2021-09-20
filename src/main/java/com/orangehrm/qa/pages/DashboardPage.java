package com.orangehrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.orangehrm.qa.base.TestBase.driver;

public class DashboardPage {

    @FindBy(xpath = "//h1[contains(text(), 'Dashboard')]")
    WebElement dashboardTitle;

    // Initializing Page Objects using constructor
    public DashboardPage(){
        PageFactory.initElements(driver, this);
    }

    // Action
    public boolean validateDashboardLogo(){
        Boolean flag = dashboardTitle.isDisplayed();
        return flag;
    }



}
