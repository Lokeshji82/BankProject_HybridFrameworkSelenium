package LearnTestCaseWriting;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import LearnPOM.LoginPage;

public class TC_001_Login extends BaseClass{

	@Test
	public void loginTest() throws IOException {
		LoginPage lp = new LoginPage(driver);
//		lp.setUserName(username);
//		lp.setPassword(pwd);
//		lp.clickSubmit();
		
		String expTitle = "Daily Journal";
		if(driver.getTitle().equals(expTitle)) {
			Assert.assertTrue(true);
		}else {
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
		}
	}
}
