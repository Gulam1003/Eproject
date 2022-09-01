package com.eproject.testCases;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.eproject.utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig readConfig = new ReadConfig();
	
	public String baseURL=readConfig.getApplicationURL();
	public String username=readConfig.getUserEmail();
	public String password=readConfig.getPassword();
	public static WebDriver driver;
	
	public static Logger logger;
	
	@BeforeClass
	@Parameters("browser")
	public void setup(String br) throws InterruptedException
	{
		Thread.sleep(10000);
		logger = LogManager.getLogger("Eproject");
		if(br.equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver", readConfig.getChromePath());
		driver=new ChromeDriver();
		}
		else if(br.equals("firefox"))
		{
		System.setProperty("webdriver.gecko.driver", readConfig.getFireFoxPath());
		driver=new FirefoxDriver();
		}
//		else if(br.equals("ie"))
//		{
//		System.setProperty("webdriver.ie.driver", readConfig.getChromePath());
//		driver=new InternetExplorerDriver();
//		}
		driver.manage().timeouts().implicitlyWait((Duration.ofSeconds(10)));
		driver.manage().window().maximize();
		Thread.sleep(5000);
		
		
	} 
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
//	public void captureScreen(WebDriver driver, String tname) throws IOException {
//		TakesScreenshot ts = (TakesScreenshot) driver;
//		File source = ts.getScreenshotAs(OutputType.FILE);
//		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
//		FileUtils.copyFile(source, target);
//		System.out.println("Screenshot taken");
//		
//	}
	
}
