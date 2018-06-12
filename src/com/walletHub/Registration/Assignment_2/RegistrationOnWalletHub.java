package com.walletHub.Registration.Assignment_2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class RegistrationOnWalletHub 
{
	static WebDriver driver;
	static String Registration_URL="https://wallethub.com/join/light";
	
	@BeforeClass
	public void BroswerInvoke()
	{
		//Setting the browser property
		System.setProperty("webdriver.gecko.driver", "D:\\SeleniumJars\\geckodriver-v0.20.0-win64\\geckodriver.exe");
		
		//Instantiating the FirefoxDriver driver
		driver=new FirefoxDriver();
		
		//Maximizing Browser
		driver.manage().window().maximize();
		
		//Synchronizing the page for 2 seconds to load the page
		driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.SECONDS);
		
		//Synchronizing the page for 2 seconds to load the element of page
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		
		//To get URL
		driver.get(Registration_URL);
	}
	
	@Test
	public void Register() throws InterruptedException
	{			
		//To enter userID
		WebElement EmailID=driver.findElement(By.xpath("//input[@type='text' and @name='em']"));
		EmailID.sendKeys("dheerajps77@gmail.com");
		
		//To enter password
		WebElement Password=driver.findElement(By.xpath("//input[@type='password' and @name='pw1']"));
		Password.sendKeys("India@123");
		
		//To enter confirm password
		WebElement ConfirmPassword=driver.findElement(By.xpath("//input[@type='password' and @name='pw2']"));
		ConfirmPassword.sendKeys("India@123");
		
		//To clicking on checkbox button
		WebElement chkbox = driver.findElement(By.xpath("//input[@type='checkbox']//following::i[1]"));
		 
		//Mouse hoverig to checkbox button
		Actions actions = new Actions(driver);
		actions.moveToElement(chkbox).click().perform();
		
		//To clicking on Submitting button
		WebElement Join=driver.findElement(By.xpath("//button[@type='button']"));
		Join.click();		
		Thread.sleep(3000);
	}
	
	@AfterClass
	public void CloseBroswer()
	{
		driver.close();
	}

}
