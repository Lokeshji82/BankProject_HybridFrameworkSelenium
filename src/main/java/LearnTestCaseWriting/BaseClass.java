package LearnTestCaseWriting;

 
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import LearnUtilities.ReadConfig;

public class BaseClass {
	
	ReadConfig readConfig =  new  ReadConfig();
	public String baseURL = readConfig.getApplicationURL();
	public String username = readConfig.getUserName();
	public String pwd = readConfig.getPassword();
	public String cpath = readConfig.getChromePath();
	
	public static WebDriver driver;
	
	@BeforeClass
	public void setup(String browser) {
		PropertyConfigurator.configure("bankproject");
		BasicConfigurator.configure();

			System.setProperty("webdriver.chrome.driver", readConfig.getChromePath());
			driver = new ChromeDriver();
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot tks = (TakesScreenshot)driver;
		File src = tks.getScreenshotAs(OutputType.FILE);
		File trg = new File(System.getProperty("user.dir") + "/Screenshot/" + tname+".png");
		FileUtils.copyFile(src, trg);
		System.out.println("Screenshot taken");
	}
}