package com.asynctric.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.asynctric.qa.base.TestBase;

public class LoginPage extends TestBase{

//Initilization page factory	
	public LoginPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}
	
//Page Factory --OR
	
	@FindBy(id="email")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(xpath="//span[text()='Log In']")
	WebElement submitbtn;
	
	@FindBy(xpath="//img[contains(@class,jss977)]")
	WebElement loginpageimage;
	
//Actions	
	public String ValidateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean ValidateImage()
	{
		return loginpageimage.isDisplayed();
	}
	
	public HomePage Login(String un,String pwd)
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		submitbtn.clear();
		return new HomePage();
	}
}
