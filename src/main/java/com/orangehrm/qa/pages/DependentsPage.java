package com.orangehrm.qa.pages;

import com.orangehrm.qa.base.TestBase;
import com.orangehrm.qa.utils.TestUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DependentsPage extends TestBase {

    // Object Repo
    @FindBy(id = "btnAddDependent")
    WebElement BtnAddDependent;

    @FindBy(id = "btnSaveDependent")
    WebElement BtnSaveDependent;

    @FindBy(id = "dependent_name")
    WebElement DependentName;

    @FindBy(id = "dependent_relationshipType")
    WebElement DependentRelationshipType;

    @FindBy(id = "dependent_dateOfBirth")
    WebElement DependentDateOfBirth;

    // Note: This div becomes visible if you select other in DependentRelationshipType.
    @FindBy(id = "dependent_relationship")
    WebElement DependentRelationship;

    @FindBy(className = "message")
    WebElement CheckStatusDiv;

    // Initializing Page Objects using constructor
    public DependentsPage(){
        PageFactory.initElements(driver, this);
    }

    public void clickOnAddDependentBtn(){
        TestUtil.doClick(BtnAddDependent);
    }

    public void AddDependentName(String dependentName){
        TestUtil.doSendKeys(DependentName, dependentName);
    }

    public void AddDependentRelationshipType(String dependentRelationshipType, String dependentRelationship) throws InterruptedException {
        TestUtil.selectDropdownValue(DependentRelationshipType, dependentRelationshipType);
        TestUtil.doSendKeys(DependentRelationship, dependentRelationship);
    }

    public void AddDependentDateOfBirth(String dependentDateOfBirth) throws InterruptedException {
       TestUtil.SelectDateFromCalenderCustom(driver, DependentDateOfBirth, dependentDateOfBirth);
    }

    public void clickOnSaveDependentBtn(){
        TestUtil.doClick(BtnSaveDependent);
    }

    public boolean isDependentsAdded(){
        System.out.println(CheckStatusDiv.getText());
        Boolean flag = TestUtil.checkStatus(CheckStatusDiv);
        return flag;
    }

}
