package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) 
	{
		super(driver);
	}
	
	@FindBy(xpath = "//span[normalize-space()='My Account']")
	WebElement MyAccountdd;
	
	@FindBy(xpath = "(//a[normalize-space()='Register'])[1]")
	WebElement reglnk;
	
	@FindBy(xpath = "//a[normalize-space()='Login']")
	WebElement loginlnk;
	
	public void clickMyAccount() 
	{
		MyAccountdd.click();
	}
	
	public void clickRegister() 
	{
		reglnk.click();
	}
	
	public void clickLogin()
	{
		loginlnk.click();
	}
}
