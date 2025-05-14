package identifyCourses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import basePage.BasePage;
import pageobjects.CourseraObjects;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class WebDevCourses extends BasePage {
	
    public WebDevCourses() throws IOException {
    	
		super();
		// TODO Auto-generated constructor stub
	}

//	private static WebDriver driver;
    @BeforeTest
    public void setup() {
    	driver = getDriver();
    	driver.get(getURL());
        // Initialize ChromeDriver instance and maximize window
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        // Navigate to the website
//        driver.get("https://www.coursera.org/");
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterTest
    public static void closeBrowser() {
        // Close the browser instance
        driver.quit();
    }
    @Test(priority=1)
    public static void searchWebDevCourses() {
    	CourseraObjects courses= new CourseraObjects(driver);
//    	CourseraObjects courses= new CourseraObjects(driver);
        // Find the search box and enter search query for web development courses
        courses.getSearchbox().sendKeys("Web development courses");
        // Click on the search button
        courses.getSearchbutton().click();
        // Filter for English language
        courses.getEnglishfilter().click();
        //Filter for beginner level courses
        courses.getBeginnerfilter().click();
        courses.getCourseElements();
        
    }
}

