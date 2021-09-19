package com.orangehrm.qa.pages;

import com.orangehrm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

    // Page Library / Object Repo
    @FindBy(name="txtUsername")
    WebElement username;

    @FindBy(name = "txtPassword")
    WebElement password;

    @FindBy(id= "logInPanelHeading")
    WebElement loginPanel;

    @FindBy(id="btnLogin")
    WebElement loginBtn;

    // Initializing Page Objects using constructor
    public LoginPage(){
        PageFactory.initElements(driver, this);
    }

    // Page Actions
    public String validateLoginPageTitle(){
        return driver.getTitle();
    }

    public boolean validateLoginPanel(){
        return loginPanel.isDisplayed();
    }

    public DashboardPage login(String uname, String pwd){
        username.sendKeys(uname);
        password.sendKeys(pwd);

        loginBtn.click();

        return new DashboardPage();
    }

}
