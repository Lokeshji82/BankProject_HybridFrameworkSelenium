package LearnPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver) {
		ldriver =	rdriver ;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id="username")
	WebElement userName;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(name = "submit")
	WebElement submit;
	
	public void setUserName(String name) {
		userName.sendKeys(name);
	}
	
	public void setPassword(String pwd) {
		password.sendKeys(pwd);
	}
	
	public void clickSubmit() {
		submit.click();
	}
}
