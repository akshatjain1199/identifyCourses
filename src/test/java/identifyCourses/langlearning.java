package identifyCourses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import basePage.BasePage;
import pageobjects.CourseraObjects;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class langlearning extends BasePage {
	public langlearning() throws IOException {
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
    public static void languagelearning() throws InterruptedException {
    	CourseraObjects languagelearning= new CourseraObjects(driver);
        // Click on Coursera logo to go back to homepage
        languagelearning.getHomepage().click();
        // Find the search box and enter search query for language learning
     
        languagelearning.getSearchbox().sendKeys("Language learning");
        // Click on the search button
        languagelearning.getSearchbutton().click();
//    public static void alllanguages() throws InterruptedException {
        // Click the button to show more language options
        languagelearning.getShowlanguage().click();
        // Select all languages
//        List<WebElement> languages = driver.findElements(By.cssSelector("div[aria-label='Select Language options'] div[class='cds-checkboxAndRadio-labelText']"));
//        for (WebElement selectedlanguage : languages) {
//            if (!selectedlanguage.isSelected()) {
//                selectedlanguage.click();
//            }
//        }
        languagelearning.getSelectalllang();
        // Apply the selected languages
        languagelearning.getApply().click();
    
//    public static void levels() throws InterruptedException {
//	Actions actions = new Actions(driver);
        languagelearning.getAlllevels();
	    // Find all level checkboxes
//	    By checkBoxLocator = By.xpath("//label[contains(text(),'Level')]/following-sibling::div //input");
//	    List<WebElement> levels = driver.findElements(checkBoxLocator);
//	    int i = 0;
//	    String[] str = {"Beginner", "Intermediate", "Advanced", "Mixed"};
//	    for (WebElement level : levels) {
//	        if (!level.isSelected()) {
//	            // Click the level checkbox
//	            level.click();
//
//	            // Find all course elements for the selected level
//	            List<WebElement> languagecourses = driver.findElements(By.xpath("//div[@data-e2e='product-card-cds']"));
//	            // Display the total count of courses for the level
//	            System.out.println("\nTotal count of courses for the level\n "
//	                    + str[i++] + " : " + languagecourses.size());
//
//	            // Display the course names for the level
//	            for (WebElement languagecourse : languagecourses) {
//	                String courseName = languagecourse.findElement(By.cssSelector("a[id*='product-card-title'] h3[class='cds-CommonCard-title css-1sktkql']")).getText();
//	                System.out.println("Course Name: " + courseName);
//	            }

//        actions.moveToElement(level).build().perform();
//	            level.click();
            Thread.sleep(2000); // wait for the page to refresh after unselecting the level
	        }

//    public static void closeBrowser() {
//        // Close the browser instance
//        driver.quit();
//    }
}
