package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {

	@Test (groups = {"Regression", "Master"})
	public void verify_account_registration() {
		
		logger.info("Starting TC001_AccountRegistrationTest");
		
		try
		{
		HomePage hp = new HomePage(driver);
		
		logger.info("clicking on my account link");
		
		hp.clickMyAccount();
		
		logger.info("Clicked on my account link");
		
		logger.info("Clicking on register link");
		
		hp.clickRegister();
		
		logger.info("Clicked on on register link");

		AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
		
		logger.info("Entering user details");
		
		regpage.setFirstName(randomString().toLowerCase());
		regpage.setLastName(randomString().toLowerCase());
		
		regpage.setEmail(randomString()+"@gmail.com");
		
		regpage.setTelephone(randomNum());
		
		String password = randomAlphaNum();
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		
		logger.info("Entered details user");
		
		regpage.clickPrivacyPolicay();
		regpage.clickContinueButton();
		
		logger.info("Validating expected message");
		String cnfmsg = regpage.getConfirmationMsg();
		
		if(cnfmsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		//Assert.assertEquals(cnfmsg, "Your Has Been Created!");
		
		else
		{
			logger.error("Test Failed");
			logger.debug("debug logs...");
			Assert.assertTrue(false);
		}
		
		
		}catch(Exception e)
		{
		
			Assert.fail();
		}
		
		logger.info("Finished TC001_AccountRegistrationTest");

	}

}
