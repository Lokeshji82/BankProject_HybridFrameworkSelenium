package bankproject.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	WebDriver ldriver;
	
	public AddCustomerPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	// identify the elements present in the web using the how keyword.
	
	@FindBy(how= How.XPATH, using="/html/body/div[3]/div/ul/li[2]/a")
	@CacheLookup
	WebElement linkAddNewCustomer;
	
	
	@FindBy(how= How.NAME, using="name")
	@CacheLookup
	WebElement txtCustomerName;
	
	@FindBy(how= How.NAME, using="rad1")
	@CacheLookup
	WebElement rdGender;
	
	@FindBy(how= How.ID_OR_NAME, using="dob")
	@CacheLookup
	WebElement txtdob;
	
	@FindBy(how= How.NAME, using="addr")
	@CacheLookup
	WebElement txtAddress;
	
	@FindBy(how= How.NAME, using="city")
	@CacheLookup
	WebElement txtCity;
	
	@FindBy(how= How.NAME, using="state")
	@CacheLookup
	WebElement txtState;
	
	@FindBy(how= How.NAME, using="pinno")
	@CacheLookup
	WebElement txtpinno;
	
	
	@FindBy(how= How.NAME, using="telephoneno")
	@CacheLookup
	WebElement txttelephoneno;
	
	@FindBy(how= How.NAME, using="emailid")
	@CacheLookup
	WebElement txtemail;
	
	@FindBy(how= How.NAME, using="password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(how= How.NAME, using="sub")
	@CacheLookup
	WebElement btnSubmit;
	
	
	public void clickAddNewCustomer() {
		linkAddNewCustomer.click();
	}
	
	public void custName(String cname) {
		txtCustomerName.sendKeys(cname);
	}
	
	public void custGender(String cgender) {
		rdGender.click();
	}
	
	public void custDob(String mm, String dd, String yy) {
		txtdob.sendKeys(mm);
		txtdob.sendKeys(dd);
		txtdob.sendKeys(yy);
	}
	
	public void custAddress(String caddress) {
		txtAddress.sendKeys(caddress);
	}
	
	public void custCity(String ccity) {
		txtCity.sendKeys(ccity);
	}
	
	public void custState(String cstate) {
		txtState.sendKeys(cstate);
	}
	
	public void custpinno(String cpinno) {
		txtpinno.sendKeys(String.valueOf(cpinno));
	}
	
	public void custtelephoneno(String ctelephoneno) {
		txttelephoneno.sendKeys(ctelephoneno);
	}
	
	public void custEmailid(String cemailid) {
		txtemail.sendKeys(cemailid);
	}
	
	public void custPassword(String cpassword) {
		txtPassword.sendKeys(cpassword);
	}
	
	public void custsubmit() {
		btnSubmit.click();
	}
}
