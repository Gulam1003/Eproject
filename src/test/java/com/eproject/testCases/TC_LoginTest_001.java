package com.eproject.testCases;


import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.eproject.pageObjects.LoginPage;



public class TC_LoginTest_001 extends BaseClass {
	
	
	
	@Test
	public void loginTest() throws InterruptedException
	{
		driver.get(baseURL);
		
		
		logger.info("URL is open......");
		
		Thread.sleep(5000);
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("User Name provided..............");
		lp.setPassword(password);
		logger.info("Password provided..............");
		lp.clickLogin();
		logger.info("Login in Clicked..............");
		if (driver.getTitle().equals("OrangeHRM"))
				{
//					Assert.assertTrue(true);
					logger.info("Inside page.................");
					Thread.sleep(5000);
					driver.navigate().refresh();
					lp.mouseClick();
					logger.info("Mouse hover Clicked..............");
					lp.clickLogout();
					logger.info("Log out Clicked..............");
				}
		else
		{
//			try {
//				captureScreen(driver, "loginTest");
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			Assert.assertTrue(false);
			logger.info("Login Failed..............");
			
		}
	}
	
	
			
}
