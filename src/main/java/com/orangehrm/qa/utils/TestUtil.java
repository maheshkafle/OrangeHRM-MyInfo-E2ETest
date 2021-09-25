package com.orangehrm.qa.utils;

import com.orangehrm.qa.base.TestBase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
public class TestUtil extends TestBase {

    public static void doSendKeys(WebElement locator, String text){
        locator.clear();
        locator.sendKeys(text);
    }

    public static void doClick(WebElement locator){
        locator.click();
    }

    public static void uploadAttachment(WebElement btnAdd, WebElement btnUpload, WebElement btnSave, String attachmentPath){
        btnAdd.click();
        btnUpload.sendKeys(attachmentPath);
        btnSave.click();
    }

    public static void selectDropdownValue( WebElement locator, String value) throws InterruptedException {
        Select dropdown_option = new Select(locator);
        dropdown_option.selectByValue(value);
        Thread.sleep(3000);
    }

    public static boolean checkStatus(WebElement locator){
        System.out.println(locator.getText());
        Boolean flag = locator.isDisplayed();
        return flag;
    }


    public static void SelectDateFromCalenderCustom(WebDriver driver, WebElement locator, String dateVal) throws InterruptedException {

        String dateArr[] = dateVal.split("-"); //{30, September, 2021}
        String year = dateArr[0];
        String month = dateArr[1];
        String day = dateArr[2];

        //WebElement input = driver.findElement(By.id("personal_txtLicExpDate"));
        locator.click();
        Select select1 = new Select(driver.findElement(By.className("ui-datepicker-month")));
        select1.selectByVisibleText(month);
        Thread.sleep(2000);

        Select select2 = new Select(driver.findElement(By.className("ui-datepicker-year")));
        select2.selectByVisibleText(year);
        Thread.sleep(2000);
        /*
        /html/body/div[3]/table/tbody/tr[1]/td[3]
        /html/body/div[3]/table/tbody/tr[1]/td[4]
        /html/body/div[3]/table/tbody/tr[1]/td[5]
        /html/body/div[3]/table/tbody/tr[1]/td[6]
        /html/body/div[3]/table/tbody/tr[1]/td[7]
        */

        String beforeXpath = "/html/body/div[3]/table/tbody/tr[";
        String afterXpath = "]/td[";

        final int totalWeekDays = 7;

        boolean flag = false;
        String dayVal = null;
        for (int rowNum = 1; rowNum <= 5 ; rowNum++) {

            for (int colNum = 1; colNum <= totalWeekDays; colNum++) {

                try {
                    dayVal = driver.findElement(By.xpath(beforeXpath + rowNum + afterXpath + colNum + "]")).getText();
                } catch (NoSuchElementException e) {
                    System.out.println("Please enter a correct value");
                    flag = false;
                    break;
                }
                System.out.println(dayVal);
                if (dayVal.equals(day)) {
                    WebElement ele = driver.findElement(By.xpath(beforeXpath + rowNum + afterXpath + colNum + "]"));
                    ele.click();
                    Thread.sleep(500);
                    flag = true;
                    break;

                }
            }
            if (flag) {
                break;
            }
        }
    }
}
