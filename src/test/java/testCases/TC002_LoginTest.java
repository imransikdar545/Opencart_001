package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.lang.AssertionError;


import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass
{
	@Test (groups = {"Sanity", "Master"})
	public void verify_login()
	{
		logger.info("Starting TC002_LoginTest");
		
		try
		{
		HomePage hp = new HomePage(driver);
		
		logger.info("clicking on my account link");
		hp.clickMyAccount();
		logger.info("Clicked on my account link");
		
		hp.clickLogin();
		logger.info("Clicked on on register link");
		
		LoginPage lp = new LoginPage(driver);
		logger.info("Entering login details");
		
		lp.setEmail(p.getProperty("email"));
		lp.setpassword(p.getProperty("pwd"));
		logger.info("entered login details");
		
		lp.clickLogin();
		logger.info("Clicked on login button");
		
		logger.info("Validating expected message");
		MyAccountPage myaccount = new MyAccountPage(driver);
		boolean targetpage = myaccount.inMyAccountPageExists();
		
		Assert.assertEquals(targetpage, true);
		}
		catch (Exception e)
		{
			Assert.fail();
		}
		logger.info("Finished TC002_LoginTest");

	}

}
