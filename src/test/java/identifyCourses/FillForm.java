package identifyCourses;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import basePage.BasePage;
import pageobjects.CourseraObjects;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

public class FillForm extends BasePage {
    public FillForm() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
    @BeforeTest
    public void setup() {
    	driver = getDriver();
    	driver.get(getURL());
    }
    @AfterTest
    public static void closeBrowser() {
        // Close the browser instance
        driver.quit();
    }
    
    @Test
    public static void formuniversity() throws IOException, InterruptedException {
    	CourseraObjects formdetails= new CourseraObjects(driver);
        // Navigate to the university page
        formdetails.getHomepage().click();
        formdetails.getEnterprise().click();
        formdetails.getForcampus().click();
        // Fill out the form with user information
        
        FileInputStream userdata= new FileInputStream("./src/main/java/Resources/credentials.xlsx");
        XSSFWorkbook workbook= new XSSFWorkbook(userdata);
        XSSFSheet sheet= workbook.getSheetAt(0);
        int rowcount= sheet.getLastRowNum();
        int colcount= sheet.getRow(1).getLastCellNum();
        CourseraObjects option = new CourseraObjects(driver);
     
        for(int i=1;i<=rowcount;i++) {
        	
        	XSSFRow celldata=sheet.getRow(i);
        	String firstN= celldata.getCell(0).getStringCellValue();
        	String lastN= celldata.getCell(1).getStringCellValue();
        	String e_mail= celldata.getCell(2).getStringCellValue();
        	String P_no= celldata.getCell(3).getStringCellValue();
        	String Ins_type= celldata.getCell(4).getStringCellValue();
        	String Ins_name= celldata.getCell(5).getStringCellValue();
        	String jb_role= celldata.getCell(6).getStringCellValue();
        	String departm= celldata.getCell(7).getStringCellValue();
        	String speciality= celldata.getCell(8).getStringCellValue();
        	String Country= celldata.getCell(9).getStringCellValue();
        	String State= celldata.getCell(10).getStringCellValue();
//        	formdetails.getFirstName().clear();
        	formdetails.getFirstName().sendKeys(firstN);
        	formdetails.getLastName().sendKeys(lastN);
//        	formdetails.getLastName().clear();
        	formdetails.getEmail().sendKeys(e_mail);
//        	formdetails.getEmail().clear();
        	formdetails.getPhone().sendKeys(P_no);        
//        	formdetails.getPhone().clear();
          Select Institutetype = new Select(option.getInstitute());
          Institutetype.selectByVisibleText(Ins_type);
          option.getCompany().sendKeys(Ins_name);
//          formdetails.getCompany().clear();
          Select jobrole = new Select(option.getJobrole());
          jobrole.selectByVisibleText(jb_role);
          Select Department = new Select(option.getDepartment());
          Department.selectByVisibleText(departm);
          Select domain = new Select(option.getDomain());
          domain.selectByVisibleText(speciality);
          Select country = new Select(option.getCountry());
          country.selectByVisibleText(Country);
          Select state = new Select(option.getState());
          state.selectByVisibleText(State);
          formdetails.getSubmit().click();
          System.out.println(i+"."+firstN+" || " +lastN+" || "+e_mail+" || "+P_no+" || "+Ins_type+" || "+Ins_name+" || "
        	       +jb_role+" || "+departm+" || "+speciality+" || "+Country+" || "+State);
          try {
              WebElement validationMsg = option.getErrormessage(); // Replace "ValidMsgEmail" with the actual ID of the validation message
              String validationText = validationMsg.getText();
              if (validationText.contains("Must be valid email")) {
                  // Take a screenshot
                  File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                  Files.copy(screenshotFile, new File("C:\\Users\\2309107\\eclipse-workspace\\IdentifyCourseFinalProject\\Screenshots\\coursera.jpg"));
              }
              System.out.println("Email Address is wrong");
          } catch (Exception e) {
              System.out.println("No alert present");
              System.out.println("Form submitted successfully!");
          }
          
          
          
//        Thread.sleep(20000);
        formdetails.getCoursesforcampus().click();
//        Thread.sleep(8000);
        }
//        try {
//            String errorMessage = formdetails.getErrormessage().getText();
//            if (errorMessage.contains("Must be valid email")) {
//                System.out.println("\nError Message is : " + errorMessage);
//            } else {
//                // Assuming successful login here
//                System.out.println("Form submitted successfully!");
//            }
//        } catch (Exception e) {
//            // Handle any exceptions here (e.g., locator not found)
//            System.out.println("Form submitted successfully!");
//        }

    }

}
        