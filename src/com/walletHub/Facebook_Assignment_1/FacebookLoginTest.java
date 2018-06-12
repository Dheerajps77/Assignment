package com.walletHub.Facebook_Assignment_1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class FacebookLoginTest 
{
	static WebDriver driver;
	//public String UsernameText;
	//public String PasswordText;
	
	@BeforeMethod
	public void setUpBroswer()
	{
		System.setProperty("webdriver.gecko.driver", "D:\\SeleniumJars\\geckodriver-v0.20.0-win64\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);	
	}
	
	@Test
	public void VerifyLoginCredential()
	{
		ExtentHtmlReporter report=new ExtentHtmlReporter("D:/Eclipse selenium Program/wallethub/reports/FacebookLogin.html");
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(report);
		
		ExtentTest test=extent.createTest("FaceBookLogin");
		
		test.log(Status.INFO, "Login to Facebook page");
		
		driver.get("https://www.facebook.com/");		
		FacebookLoginPage FLP=new FacebookLoginPage(driver);
		FLP.LoginToPage("sdfsdfsd@gmail.com", "sfdsldja");

		test.log(Status.PASS, "Action has been performed successfully");
		extent.flush();
	}
	
	@AfterMethod
	public void CloseBroswer()
	{
		driver.close();
	}

}
