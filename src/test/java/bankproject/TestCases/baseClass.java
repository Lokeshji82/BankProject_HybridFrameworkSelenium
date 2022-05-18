package bankproject.TestCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import bankproject.Utilities.ReadConfig;

 

public class baseClass {
	
	ReadConfig readConfig = new ReadConfig();
		
	public String baseURL = readConfig.getApplicationURL();
	public String username = readConfig.getUserName();
	public String password  = readConfig.getPassword();
	public static WebDriver driver;
	
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {
		
		logger = Logger.getLogger("bankproject");
		PropertyConfigurator.configure("log4j.properties");
	    BasicConfigurator.configure();
	    
	    if(br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", readConfig.getChromePath());
			driver = new ChromeDriver();
	    } else if(br.equals("firefox")) {
	    	System.setProperty("webdriver.gecko.driver", readConfig.getFireFoxPath());
//	    	driver = new geckodriver();
	    }else {
	    	System.setProperty("webdriver.gecko.driver", readConfig.getIEPath());
//	    	driver = new IEDriverServer(); download the respective driver and update in the Drivers folder
	    }
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.get(baseURL);
	    driver.manage().window().maximize();
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	// Taking screenshot for the failure
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts =  (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" +tname+ ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken...");
	}
}
