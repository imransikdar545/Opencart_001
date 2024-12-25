package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) 
	{
		super(driver);
	}
	
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement email_input;
	
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement pass_input;
	
	@FindBy(xpath = "//input[@value='Login']")
	WebElement loginbtn;
	
	public void setEmail(String email)
	{
		email_input.sendKeys(email);
	}
	
	public void setpassword(String pwd)
	{
		pass_input.sendKeys(pwd);
	}
	
	public void clickLogin()
	{
		loginbtn.click();
	}

}
