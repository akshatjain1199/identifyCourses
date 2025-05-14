package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CourseraObjects {
 public WebDriver driver;
 By searchbox= By.cssSelector("input[placeholder='What do you want to learn?']");
 By searchbutton= By.cssSelector("button[class='nostyle search-button'] div[class='magnifier-wrapper']");
 By englishfilter= By.xpath("//div[@class='css-12o3uw8']//div[2]//div[1]//label[1]");
 By beginnerfilter= By.cssSelector("div[data-testid='Beginner-false']");
 By courseelements=By.xpath("//div[@data-e2e='product-card-cds']");
 By coursename= By.cssSelector("a[id*='product-card-title'] h3[class='cds-CommonCard-title css-1sktkql']");
 By showlanguages= By.xpath("//button[@aria-label='Show more Language options']");
 By alllanguages= By.cssSelector("div[aria-label='Select Language options'] div[class='cds-checkboxAndRadio-labelText']");
 By apply=By.xpath("//span[normalize-space()='Apply']");
 By levels= By.xpath("//label[contains(text(),'Level')]/following-sibling::div //input");
 By courses= By.xpath("//div[@data-e2e='product-card-cds']");
 By homepage= By.cssSelector("a[aria-label='Coursera']");
 By enterprise= By.linkText("For Enterprise");
 By forcampus=By.xpath("//a[@data-click-key='ent_website._business.click.navigation_meta_nav_Campus']");
 By firstname= By.xpath("//input[@id='FirstName']");
 By lastname= By.xpath("//input[@id='LastName']");
 By email= By.xpath("//input[@id='Email']");
 By phone= By.xpath("//input[@id='Phone']");
 By institute= By.xpath("//select[@id='Institution_Type__c']");
 By company=By.xpath("//input[@id='Company']");
 By department= By.xpath("//select[@id='Department']");
 By jobrole= By.xpath("//select[@id='Title']");
 By domain= By.xpath("//select[@id='What_the_lead_asked_for_on_the_website__c']");
 By country= By.xpath("//select[@id='Country']");
 By state= By.xpath("//select[@id='State']");
 By submit= By.cssSelector("button[type='submit']");
 By errormessage= By.xpath("//div[@id='ValidMsgEmail']");
 By checkBoxLocator = By.xpath("//label[contains(text(),'Level')]/following-sibling::div //input");
 By courseElements=By.xpath("//div[@data-e2e='product-card-cds']");
 By coursesforcampus= By.cssSelector("[alt='Coursera for Campus']");
 public CourseraObjects(WebDriver driver) {
	 this.driver= driver;
 }
 public WebElement getSearchbox() {
	 return driver.findElement(searchbox);
 }
 public WebElement getSearchbutton() {
	 return driver.findElement(searchbutton);
 }
 public WebElement getEnglishfilter() {
	 return driver.findElement(englishfilter);
 } 
 public WebElement getBeginnerfilter() {
	 return driver.findElement(beginnerfilter);
 }
 public WebElement getCourseelements() {
	 return driver.findElement(courseelements);
 }
 public WebElement getCoursename() {
	 return driver.findElement(coursename);
	 
 }
 public WebElement getShowlanguage() {
	 return driver.findElement(showlanguages);
 }
 public WebElement getAlllanguages() {
	 return driver.findElement(alllanguages);
 }
 public WebElement getApply() {
	 return driver.findElement(apply);
 }
 public WebElement getLevels() {
	 return driver.findElement(levels);
 }
 public WebElement getCourses() {
	 return driver.findElement(courses);
 }
 public WebElement getHomepage() {
	 return driver.findElement(homepage);
 }
 public WebElement getEnterprise() {
	 return driver.findElement(enterprise);
 }
 public WebElement getForcampus() {
	 return driver.findElement(forcampus);
 }
 public WebElement getFirstName() {
	 return driver.findElement(firstname);
 }
 public WebElement getLastName() {
	 return driver.findElement(lastname);
 }
 public WebElement getEmail() {
	 return driver.findElement(email);
 }
 public WebElement getPhone() {
	 return driver.findElement(phone);
 }
 public WebElement getCoursesforcampus() {
	 return driver.findElement(coursesforcampus);
 }
 public WebElement getCompany() {
	 return driver.findElement(company);
 }
 public WebElement getDepartment() {
	 return driver.findElement(department);
 }
 public WebElement getJobrole() {
	 return driver.findElement(jobrole);
 }
 public WebElement getDomain() {
	 return driver.findElement(domain);
 }
 public WebElement getCountry() {
	 return driver.findElement(country);
 }
 public WebElement getState() {
	 return driver.findElement(state);
 }
 public WebElement getSubmit() {
	 return driver.findElement(submit);
 }
 public WebElement getErrormessage() {
	 
	 return driver.findElement(errormessage);
 }
public WebElement getInstitute() {
	// TODO Auto-generated method stub
	return driver.findElement(institute);
}
public WebElement getCheckBoxLocator() {
	return driver.findElement(checkBoxLocator);
}
public void getCourseElements(){
// Loop through the first 2 courses
	List<WebElement> courseEle = driver.findElements(courseElements);
	List<WebElement> coursenames= driver.findElements(coursename);
//	String courseNm= .findElements(coursename);
    // Loop through the first 2 courses
    for (int i = 0; i < 3; i++) {
        WebElement course = courseEle.get(i);
        // Get course name
        String courseName = course.getText();
        // Print course name
        System.out.println("Course Name: " + courseName);
    }
}
//    public void getSelectalllang() {
    
	public void getSelectalllang() {
		List<WebElement> languages = driver.findElements(alllanguages);
	    for (WebElement selectedlanguage : languages) {
	        if (!selectedlanguage.isSelected()) {
	            selectedlanguage.click();
	        }
	}
		// TODO Auto-generated method stub
		
	}
	public void getAlllevels() {
		Actions actions = new Actions(driver);
	List<WebElement> levels = driver.findElements(checkBoxLocator);
    int i = 0;
    String[] str = {"Beginner", "Intermediate", "Advanced", "Mixed"};
    for (WebElement level : levels) {
        if (!level.isSelected()) {
            // Click the level checkbox
            level.click();

            // Find all course elements for the selected level
            List<WebElement> languagecourses = driver.findElements(courseelements);
            List<WebElement> langcoursename  = driver.findElements(coursename);
            // Display the total count of courses for the level
            System.out.println("\nTotal count of courses for the level\n "
                    + str[i++] + " : " + languagecourses.size());

            // Display the course names for the level
            for (WebElement languagecourse : langcoursename) {
                String courseName = languagecourse.getText();
                System.out.println("Course Name: " + courseName);
            }
            actions.moveToElement(level).build().perform();
            level.click();

}
    }
	}
}
