package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{

	public AccountRegistrationPage(WebDriver driver) 
	{
		super(driver);
	}
	
	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement fisrtName_input;
	
	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement lastName_input;
	
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement email_input;
	
	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement phn_input;
	
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement pass_input;
	
	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement cnfpass_input;
	
	@FindBy(xpath = "//input[@name='agree']")
	WebElement checkPolicy;
	
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement continuebtn;
	
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	public void setFirstName(String fname) 
	{
		fisrtName_input.sendKeys(fname);
	}
	
	public void setLastName(String lname) 
	{
		lastName_input.sendKeys(lname);
	}
	
	public void setEmail(String email) 
	{
		email_input.sendKeys(email);
	}
	
	public void setTelephone(String tel) 
	{
		phn_input.sendKeys(tel);
	}
	
	public void setPassword(String pass) 
	{
		pass_input.sendKeys(pass);
	}
	
	public void setConfirmPassword(String cpass) 
	{
		cnfpass_input.sendKeys(cpass);
	}
	
	public void clickPrivacyPolicay()
	{
		checkPolicy.click();
	}
	
	public void clickContinueButton()
	{
		continuebtn.click();
	}
	
	public String getConfirmationMsg()
	{
		try 
		{
			return msgConfirmation.getText();
		} catch (Exception e) 
		{
			return (e.getMessage());
		}

	}

}
