package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class BaseClass {
	
	public static WebDriver driver;
	public Logger logger; //Log4j
	public Properties p;
	
	@BeforeClass (groups = {"Sanity", "Regression", "Master"})
	@Parameters ({"os", "browser"})
	public void setUp(String os, String br) throws IOException 
	{
		//loading config properties file
		
		FileReader file = new FileReader(".\\src\\test\\resources\\config.properties");
		p= new Properties();
		p.load(file);
		
		
		logger = LogManager.getLogger(this.getClass());
		
		switch (br.toLowerCase()) 
		{
		case "chrome" : driver = new ChromeDriver(); break;
		case "edge" : driver = new EdgeDriver(); break;
		case "firefox" : driver = new FirefoxDriver(); break;
		default: System.out.println("Invalid Browser Name"); return;
		}

		driver.manage().deleteAllCookies();
		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterClass (groups = {"Sanity", "Regression", "Master"})
	public void tearDown() 
	{
		driver.quit();
	}
	
	public String randomString()
	{
		String genRanString = RandomStringUtils.randomAlphabetic(5); //RandomStringUtils is not java defined class its coming from commons - langs3
		return genRanString;
	}
	
	public String randomNum()
	{
		String genRanNum = RandomStringUtils.randomNumeric(10);
		return genRanNum;
	}
	
	public String randomAlphaNum()
	{
		String genRanAlpha = RandomStringUtils.randomAlphabetic(3);
		String genRanNumeric = RandomStringUtils.randomNumeric(3);
		return (genRanAlpha+genRanNumeric);
	}

	public String captureScreen(String tname) throws IOException {
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot takescreenshot = (TakesScreenshot) driver;
		File sourceFile = takescreenshot.getScreenshotAs(OutputType.FILE);
		String targetFilePath = System.getProperty("user.dir")+"\\screenshots\\"+ tname + "_" + timeStamp + ".png";
		File targetFIle = new File(targetFilePath);
		sourceFile.renameTo(targetFIle);
		return targetFilePath;
	}
	
}
