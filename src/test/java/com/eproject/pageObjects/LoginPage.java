package com.eproject.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver ldriver;
	public LoginPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	@FindBy(name="username")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")
	@CacheLookup
	WebElement btnLogin;
	
	@FindBy(xpath="//p[@class='oxd-userdropdown-name']")
	@CacheLookup
	WebElement hoverClick;
	
	@FindBy(xpath="//a[@class='oxd-userdropdown-link']")
	@CacheLookup
	WebElement lnkLogout;
	
	public void setUserName(String uname) 
	{
		txtEmail.clear();
		txtEmail.sendKeys(uname);
	}
	public void setPassword(String pwd)
	{
		txtPassword.clear();
		txtPassword.sendKeys(pwd);
	}
	public void clickLogin()
	{
		btnLogin.click();
	}
	public void mouseClick()
	{
		Actions action = new Actions(ldriver);
		action.moveToElement(hoverClick).click().build().perform();
	}
	public void clickLogout()
	{
		lnkLogout.click();
	}
	
}
