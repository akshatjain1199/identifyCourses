package basePage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
public class BasePage {
   
    
	public static WebDriver driver;
	private String url;
	private Properties prop;
//	private JavascriptExecutor jsExecutor;
	public BasePage() throws IOException {
		prop = new Properties();
		FileInputStream data = new FileInputStream("./src/main/java/BasePage/config.properties");
		prop.load(data);
	}
	public  WebDriver getDriver() {
		if(prop.getProperty("driver").equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}else {
			driver =  new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		return driver;
	}
	public String getURL() {
		url=prop.getProperty("url");
		return url;
	}
	public void takeSnapShot(String name) throws IOException {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		File destFile = new File(System.getProperty("user.dir") + "\\target\\screenshots\\"
				+ timestamp() + ".png");

		FileUtils.copyFile(srcFile, destFile);
	}
//	public void scrollBy(int xOffset, int yOffset) {
//		  jsExecutor.executeScript("window.scrollBy(arguments[0], arguments[1]);", xOffset, yOffset);
//	}
	private String timestamp() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
