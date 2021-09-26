package com.orangehrm.qa.pages;

import com.orangehrm.qa.base.TestBase;
import com.orangehrm.qa.utils.TestUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QualificationsPage extends TestBase {

    // Object Repo
    @FindBy(id = "addWorkExperience")
    WebElement BtnAddWorkExperience;

    @FindBy(id = "addEducation")
    WebElement BtnAddEducation;

    @FindBy(id = "addSkill")
    WebElement BtnAddSkill;

    @FindBy(id = "btnWorkExpSave")
    WebElement BtnSaveWorkExperience;

    @FindBy(id = "addLanguage")
    WebElement BtnAddLanguage;

    @FindBy(id = "addLicense")
    WebElement BtnAddLicense;

    @FindBy(id = "experience_employer")
    WebElement Company;

    @FindBy(id = "experience_jobtitle")
    WebElement JobTitle;

    @FindBy(id = "experience_from_date")
    WebElement JobStartDate;

    @FindBy(id = "experience_to_date")
    WebElement JobEndDate;

    @FindBy(id = "experience_comments")
    WebElement Comments;

    @FindBy(className = "message")
    WebElement CheckStatusDiv;

    //Hard coded xpath which contains text shi:dolutions: So pass accordingly
    @FindBy(xpath = "//a[contains(text(), 'shi:dolutions')]/parent::td//preceding-sibling::td//input[@name='delWorkExp[]']")
    WebElement WorkExpCheckbox;

    @FindBy(id = "delWorkExperience")
    WebElement BtndelWorkExperience;

    @FindBy(id = "education_code")
    WebElement EducationLevel;

    @FindBy(id = "education_institute")
    WebElement EducationInstitute;

    @FindBy(id = "education_major")
    WebElement EducationSpecialization;

    @FindBy(id = "education_year")
    WebElement EducationYear;

    @FindBy(id = "education_gpa")
    WebElement EducationGPA;

    @FindBy(id = "education_start_date")
    WebElement EducationStartDate;

    @FindBy(id = "education_end_date")
    WebElement EducationEndDate;

    @FindBy(id = "btnEducationSave")
    WebElement BtnEducationSave;

    @FindBy(id = "skill_code")
    WebElement Skill;

    @FindBy(id = "skill_years_of_exp")
    WebElement YearsOfExperience;

    @FindBy(id = "skill_comments")
    WebElement SkillComments;

    @FindBy(id = "btnSkillSave")
    WebElement BtnSkillSave;

    //Hard coded xpath which contains text shi:dolutions: So pass accordingly
    @FindBy(xpath = "//a[contains(text(), 'Java')]/parent::td//preceding-sibling::td//input[@class='chkbox']")
    WebElement SkillsCheckbox;

    @FindBy(id = "delSkill")
    WebElement BtnDelSkill;

    @FindBy(id = "language_code")
    WebElement Language;

    @FindBy(id = "language_lang_type")
    WebElement LanguageType;

    @FindBy(id = "language_competency")
    WebElement LanguageCompetency;

    @FindBy(id = "language_comments")
    WebElement LanguageComments;

    @FindBy(id = "btnLanguageSave")
    WebElement BtnLanguageSave;

    @FindBy(id = "license_code")
    WebElement LicenseType;

    @FindBy(id = "license_license_no")
    WebElement LicenseNum;

    @FindBy(id = "license_date")
    WebElement LicenseIssueDate;

    @FindBy(id = "license_renewal_date")
    WebElement LicenseRenewalDate;

    @FindBy(id = "btnLicenseSave")
    WebElement BtnLicenseSave;

    @FindBy(id = "btnAddAttachment")
    WebElement BtnAddAttachment;

    @FindBy(id = "ufile")
    WebElement BtnUpload;

    @FindBy(id = "btnSaveAttachment")
    WebElement BtnSaveAttachment;

    // Initializing Page Objects using constructor
    public QualificationsPage(){
        PageFactory.initElements(driver, this);
    }

    public void clickAddWorkExperienceBtn(){
        TestUtil.doClick(BtnAddWorkExperience);
    }

    public void AddCompany(String company){
        TestUtil.doSendKeys(Company, company);
    }

    public void AddJobTitle(String jobTitle) throws InterruptedException {
        TestUtil.doSendKeys(JobTitle, jobTitle);
    }

    public void AddJobStartDate(String jobStartDate) throws InterruptedException {
        TestUtil.SelectDateFromCalenderCustom(driver, JobStartDate, jobStartDate);
    }

    public void AddJobEndDate(String jobEndDate) throws InterruptedException {
        TestUtil.SelectDateFromCalenderCustom(driver, JobEndDate, jobEndDate);
    }


    public void AddComments(String comments){
        TestUtil.doSendKeys(Comments, comments);
    }

    public void clickSaveWorkExperienceBtn(){
        TestUtil.doClick(BtnSaveWorkExperience);
    }

    public boolean isWorkExperienceAdded() {
        Boolean flag = TestUtil.checkStatus(CheckStatusDiv);
        return flag;
    }

    public void deleteWorkExperience() {
        TestUtil.doClick(WorkExpCheckbox);
        TestUtil.doClick(BtndelWorkExperience);
    }

    public boolean isWorkExperienceDeleted() {
        Boolean flag = TestUtil.checkStatus(CheckStatusDiv);
        return flag;
    }

    public void clickAddEducationBtn(){
        TestUtil.doClick(BtnAddEducation);
    }

    public void selectEducationLevel(String valueEducationLevel) throws InterruptedException {
        TestUtil.selectDropdownValue(EducationLevel, valueEducationLevel);
    }

    public void AddEducationInstitute(String valueEducationInstitute) throws InterruptedException {
        TestUtil.doSendKeys(EducationInstitute, valueEducationInstitute);
    }

    public void AddEducationSpecialization(String valueEducationSpecialization) throws InterruptedException {
        TestUtil.doSendKeys(EducationSpecialization, valueEducationSpecialization);
    }

    public void AddEducationYear(String valueEducationYear) throws InterruptedException {
        TestUtil.doSendKeys(EducationYear, valueEducationYear);
    }

    public void AddEducationGPA(String valueEducationGPA) throws InterruptedException {
        TestUtil.doSendKeys(EducationGPA, valueEducationGPA);
    }

    public void AddEducationStartDate(String valueEducationStartDate) throws InterruptedException {
        TestUtil.SelectDateFromCalenderCustom(driver, EducationStartDate, valueEducationStartDate);
    }

    public void AddEducationEndDate(String valueEducationEndDate) throws InterruptedException {
        TestUtil.SelectDateFromCalenderCustom(driver, EducationEndDate, valueEducationEndDate);
    }

    public void clickSaveEducationBtn(){
        TestUtil.doClick(BtnEducationSave);
    }

    public boolean isEducationAdded(){
        System.out.println(CheckStatusDiv.getText());
        Boolean flag = TestUtil.checkStatus(CheckStatusDiv);
        return flag;
    }

    public void clickAddSkillBtn(){
        TestUtil.doClick(BtnAddSkill);
    }

    public void selectSkill(String valueSkill) throws InterruptedException {
        TestUtil.selectDropdownValue(Skill, valueSkill);
    }

    public void AddYearsOfExperience(String valueYearsOfExperience) throws InterruptedException {
        TestUtil.doSendKeys(YearsOfExperience, valueYearsOfExperience);
    }

    public void AddSkillComments(String valueSkillComments) throws InterruptedException {
        TestUtil.doSendKeys(SkillComments, valueSkillComments);
    }

    public void clickBtnSkillSave(){
        TestUtil.doClick(BtnSkillSave);
    }

    public boolean isSkillAdded(){
        System.out.println(CheckStatusDiv.getText());
        Boolean flag = TestUtil.checkStatus(CheckStatusDiv);
        return flag;
    }

    public void DeleteSkills() {
        TestUtil.doClick(SkillsCheckbox);
        TestUtil.doClick(BtnDelSkill);
    }

    public boolean IsSkillsDeleted() {
        Boolean flag = TestUtil.checkStatus(CheckStatusDiv);
        return flag;
    }

    public void clickAddLanguageBtn(){
        TestUtil.doClick(BtnAddLanguage);
    }

    public void selectLanguage(String valueLanguage) throws InterruptedException {
        TestUtil.selectDropdownValue(Language, valueLanguage);
    }

    public void selectLanguageType(String valueLanguageType) throws InterruptedException {
        TestUtil.selectDropdownValue(LanguageType, valueLanguageType);
    }

    public void selectLanguageCompetency(String valueLanguageCompetency) throws InterruptedException {
        TestUtil.selectDropdownValue(LanguageCompetency, valueLanguageCompetency);
    }

    public void AddLanguageComments(String valueLanguageComments) throws InterruptedException {
        TestUtil.doSendKeys(LanguageComments, valueLanguageComments);
    }

    public void clickBtnLanguageSave(){
        TestUtil.doClick(BtnLanguageSave);
    }

    public boolean isLanguageAdded(){
        System.out.println(CheckStatusDiv.getText());
        Boolean flag = TestUtil.checkStatus(CheckStatusDiv);
        return flag;
    }

    public void ClickBtnAddLicense(){
        TestUtil.doClick(BtnAddLicense);
    }

    public void AddLicenseType(String valueLicenseType) throws InterruptedException {
        TestUtil.selectDropdownValue(LicenseType, valueLicenseType);
    }

    public void AddLicenseNumber(String valueLicenseNumber){
        TestUtil.doSendKeys(LicenseNum, valueLicenseNumber);
    }

    public void AddLicenseIssueDate(String valueLicenseIssueDate) throws InterruptedException {
        TestUtil.SelectDateFromCalenderCustom(driver, LicenseIssueDate, valueLicenseIssueDate);
    }

    public void AddLicenseRenewalDate(String valueLicenseRenewalDate) throws InterruptedException {
        TestUtil.SelectDateFromCalenderCustom(driver, LicenseRenewalDate, valueLicenseRenewalDate);
    }

    public void ClickBtnLicenseSave(){
        TestUtil.doClick(BtnLicenseSave);
    }

    public boolean IsLicenseAdded(){
        System.out.println(CheckStatusDiv.getText());
        Boolean flag = TestUtil.checkStatus(CheckStatusDiv);
        return flag;
    }

    public void uploadQualificationAttach(){
        TestUtil.uploadAttachment(BtnAddAttachment, BtnUpload, BtnSaveAttachment, prop.getProperty("pathToQualificationAttachment"));
    }

    public boolean isQualificationAttachUploaded(){
        System.out.println(CheckStatusDiv.getText());
        Boolean flag = TestUtil.checkStatus(CheckStatusDiv);
        return flag;
    }
}
