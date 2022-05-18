package bankproject.TestCases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
//import org.apache.commons.lang3.RandomStringUtils;
//import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import bankproject.pageObject.AddCustomerPage;
import bankproject.pageObject.LoginPage;

public class TC_AddCustomerTest_003 extends baseClass {

	@Test
	public void addNewCustomer() throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("username is provided.");
		lp.setPassword(password);
		logger.info("Password is provided.");
		lp.clickSubmit();

		// till here login process
		Thread.sleep(3000);
		// now performing the action in this class
		AddCustomerPage addcust = new AddCustomerPage(driver);
		addcust.clickAddNewCustomer();
		
		logger.info("Providing the customer details....	");
		
		addcust.custName("Lokesh");
		addcust.custGender("Male");
		addcust.custDob("01", "20", "1998");
		Thread.sleep(3000);
		addcust.custAddress("INDIA");
		addcust.custCity("bengaluru");
		addcust.custState("KA");
		addcust.custpinno("560006");
		addcust.custtelephoneno("999999");

		String email = randomString() + "@gmail.com";  // generating dynamically
		addcust.custEmailid(email);
		
		addcust.custPassword("abcdef");
		addcust.custsubmit();
		
		Thread.sleep(3000);
		
		// now validating customer added successful message.
		
		logger.info("Validation started");
		
		boolean res = driver.getPageSource().contains("Cutomer Registered Successfully!!!");
		
		if(res == true) {
			Assert.assertTrue(true);
			logger.info("Test case is passed");
			
		}else {
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
			logger.info("Test case is failed");
		}
		
	}

	// generating random srting
	public String randomString() {
		String generateString = RandomStringUtils.randomAlphabetic(8); // will generate random string with 8 characters
																		// dynamically (randomly)
		return generateString;
	}
	
	public static String randomNum() {
		String generateString2 = RandomStringUtils.randomNumeric(8); // will generate random string with 8 characters
																		// dynamically (randomly)
		return generateString2;
	}
}
