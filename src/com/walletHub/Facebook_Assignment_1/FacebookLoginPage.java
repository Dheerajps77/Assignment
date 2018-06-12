package com.walletHub.Facebook_Assignment_1;

//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class FacebookLoginPage 
{
	
	WebDriver driver;
	
	By username=By.xpath("//input[@name='email' and @data-testid='royal_email']");
	By password=By.xpath("//input[@name='pass' and @data-testid='royal_pass']");
	By LoginButton=By.xpath("//input[@value='Log In' and @data-testid='royal_login_button']");
	
	public FacebookLoginPage(WebDriver driver)
	{
		this.driver=driver;	
	}
	
	public void LoginToPage(String User, String Password)
	{
		driver.findElement(username).sendKeys(User);
		driver.findElement(password).sendKeys(Password);
		driver.findElement(LoginButton).click();
	}
}

