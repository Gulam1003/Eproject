package com.eproject.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.eproject.pageObjects.LoginPage;
import com.eproject.utilities.XLUtils;
   


public class TC_LoginDDT_002 extends BaseClass 
{	
	
	
	
	@Test(dataProvider="LogData")
	public void loginTestD(String user ,String pwd) throws InterruptedException 
	{
		
		
	logger.info("Getting base URL............");
	driver.get(baseURL);
	
	logger.info("URL is open......");
	
	Thread.sleep(5000);
	LoginPage lp = new LoginPage(driver);
	lp.setUserName(user);
	logger.info("User Name provided..............");
	lp.setPassword(pwd);
	logger.info("Password provided..............");
	Thread.sleep(5000);
	lp.clickLogin();
	logger.info("Login in Clicked..............");
	if (driver.getTitle().equals("OrangeHRM"))
			{
				Assert.assertTrue(true);
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
//		try {
//			captureScreen(driver, "loginTest");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		Assert.assertTrue(false);
		logger.info("Login Failed..............");
		
	}
	}
	@DataProvider(name="LogData")
	public String[][] getData() throws IOException
	{
		
		String path =System.getProperty("user.dir")+"/src/test/java/com/eproject/testData/LoginData.xlsx";
		
			 int rownum = XLUtils.getRowCount(path, "Sheet1");
			 int colcount = XLUtils.getCellCount(path, "Sheet1", 1);
			 String logindata[][] = new String[rownum][colcount];
		for (int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
								logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return logindata;
	}
	
}
