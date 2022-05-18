package bankproject.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import bankproject.pageObject.LoginPage;

public class TC_LoginTest_001 extends baseClass {

	@Test
	public void loginTest() throws IOException {
		 
		logger.info("URL opened.");
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Username is entered.");
		lp.setPassword(password);
		logger.info("password is entered.");
		lp.clickSubmit();
		
		String expTitle = "Guru99 Bank Manager HomePage";
		// title verification :
		if(driver.getTitle().equals(expTitle)) {
			Assert.assertTrue(true);
			logger.info("Login Test passed");
		}else {
			
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
			logger.info("Login Test failed");
		}
	}
}
