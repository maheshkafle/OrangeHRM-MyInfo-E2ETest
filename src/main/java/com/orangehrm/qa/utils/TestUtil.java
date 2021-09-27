package com.orangehrm.qa.utils;

import com.orangehrm.qa.base.TestBase;
import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestUtil extends TestBase {

    static Workbook book;
    static Sheet sheet;

    public static String TESTDATA_SHEET_PATH = "C:\\Users\\mahesh.kafle\\IdeaProjects\\OrangeHRM-MyInfo-E2ETest\\src\\main\\java\\com\\orangehrm\\qa\\testdata\\credentials.xlsx";

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
        Thread.sleep(1000);
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

    // Method to take screenshot if an exception occurs under screenshots folder and gets called from WebEventListener class
    public static void takeScreenshotOnException() throws IOException {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String currentDir = System.getProperty("user.dir");

        FileUtils.copyFile(srcFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
    }

    public static Object[][] getTestData(String sheetName){

        FileInputStream file = null;
        try {
            file = new FileInputStream(TESTDATA_SHEET_PATH);

        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        try {
            //XSSFWorkbook book = new XSSFWorkbook(file);
            //book = WorkbookFactory.create(file);
            book = new XSSFWorkbook(file);
        }
        catch (InvalidFormatException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }

        sheet = book.getSheet(sheetName);
        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        //System.out.println(sheet.getLastRowNum() + "-------" + sheet.getRow(0).getLastCellNum());
        for (int i=0; i < sheet.getLastRowNum(); i++){
            for (int k=0; k < sheet.getRow(0).getLastCellNum(); k++){
                data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
                //System.out.println(data[i][k]);
            }
        }
        return data;
    }

}
