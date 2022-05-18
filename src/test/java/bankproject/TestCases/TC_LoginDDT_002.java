package bankproject.TestCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import bankproject.Utilities.XLUtils;
import bankproject.pageObject.LoginPage;

public class TC_LoginDDT_002 extends baseClass{
	
	@Test(dataProvider="LoginData")
	public void loginDDT(String userr, String pwdd) throws InterruptedException{
			LoginPage lp = new LoginPage(driver);
			lp.setUserName(userr);
			logger.info("username provided");
			lp.setPassword(pwdd);
			logger.info("password provided.");
			lp.clickSubmit();
			
			Thread.sleep(3000);
			
			if(isAlertPresent() == true) {
				driver.switchTo().alert().accept();  //close alert
				driver.switchTo().defaultContent();
				Assert.assertTrue(false);
				logger.warn("Login falied! ");
			}else {
				Assert.assertTrue(true);
				logger.info("Login passed");
				lp.clickLogout();
				Thread.sleep(3000);
				driver.switchTo().alert().accept();
				driver.switchTo().defaultContent();
			}
		}
	
	// user defined method created to check alert is present or not.
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		}catch (NoAlertPresentException e) {
			return false;
		}
	}
	
	// getting the data from the excel file in the 2D-Array and provide the result.	
	@DataProvider(name="LoginData")
	   public String [][] getData() throws IOException{
		
//		String excelFilePath=".\\datafiles\\countries.xlsx";
//		FileInputStream inputstream=new FileInputStream(excelFilePath);
//		
//		XSSFWorkbook workbook=new XSSFWorkbook(inputstream);
//		XSSFSheet sheet=workbook.getSheetAt(0);	//XS/SFSheet sheet=workbook.getSheet("Sheet1");
		
		
		String path = System.getProperty("user.dir")+"/src/test/java/bankproject/TestData/LoginData.xlsx";
 
		
		int rownum = XLUtils.getRowCount("Sheet1");
		int colcount = XLUtils.getCellCount("Sheet1", 1);
		
		String logindata[][] = new String[rownum][colcount];
		
		for(int i=1; i<=rownum; i++) {
			for(int j=0; j<colcount; j++) {
				logindata[i-1][j]  = XLUtils.getCellData("Sheet1", i, j);
				//internally get data from excel and store in 2d array.
			}
		}
		/*
		String logindata[][] = {
				{"loke@gmail.com", "123"}, {"as@ga.com", "456"}, {"loke@mail.com","789"}
		};
		  The Hard coded value is working.
		*/
		return logindata;
	}
}
