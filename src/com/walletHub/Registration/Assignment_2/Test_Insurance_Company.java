package com.walletHub.Registration.Assignment_2;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Test_Insurance_Company 
{
	
	static WebDriver driver;
	
	static String URL="http://wallethub.com/profile/test_insurance_company/";
	
	static String Review_text_messages ="Hi, I have got an where i needs assignment to wrie few lines "
			+ "of code for couple of modules in the walletHub site. "
			+ "I feel very nice while browsing the site because the "
			+ "site is good and very handy to use.";
	
	@BeforeClass
	public void BroswerInvoke() throws InterruptedException
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
		driver.get(URL);
		//Thread.sleep(5000);
	}
	
	@Test(priority=0)
	public void test_Insurance_company() throws InterruptedException
	{	
		//Sleeping the page for 5 seconds.
		Thread.sleep(5000);
//		WebElement hover=driver.findElement(By.xpath("//i[@class='af-icon-cross']"));
//		hover.click();
		
		//To scrolling down the page because when the "Join WalletHub"  window comes the Stars rating will get hide
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		//Scroll down to 400 pixels
		js.executeScript("window.scrollBy(0,400)");
		
		//click on 5th Stars
		WebElement Stars=driver.findElement(By.xpath("//span[contains(@class,'wh-rating rating_5')]"));
		
		//MOuse hovering to Stars
		Actions action=new Actions(driver);
		action.moveToElement(Stars).build().perform();
		
		//It will sleep the page for 3 seconds so that clicking action would get perform
		Thread.sleep(3000);
		
		//Now it will click on 5th Star
		WebElement Click_on_5thStar=driver.findElement(By.xpath("//div[contains(@class,'wh-rating-choices')]//div[contains(@class,'wh-rating-choices-holder')]//a[5]"));
		Click_on_5thStar.click();
		Thread.sleep(3000);
	}
	
	@Test(priority=1)
	public void SubmitRating() throws InterruptedException
	{
		//Will click on dropdown list 
		WebElement Policy_Dropdown=driver.findElement(By.xpath("//div[contains(@class,'dropdown-title')]"));
		Policy_Dropdown.click();
		
		//Will click on Health element
		WebElement Click_On_Health=driver.findElement(By.xpath("//ul[contains(@class,'drop-el')]//li[2]"));
		Click_On_Health.click();
		Thread.sleep(2000);
		
		//Click on the 5th Star
		WebElement Check_5th_Star=driver.findElement(By.xpath("//span[@id='overallRating']//a[5]"));
		Check_5th_Star.click();
		Thread.sleep(2000);
		
		//Writing the review text
		WebElement Review_TextField=driver.findElement(By.xpath("//textarea[@id='review-content']"));
		Review_TextField.sendKeys(Review_text_messages);
		
		//Click on submit button
		WebElement Submitt_button=driver.findElement(By.xpath("//input[contains(@class,'btn blue') and @type='submit']"));
		Submitt_button.click();	
	
	}
	
	@Test(priority=2)
	public static void Login()throws Exception
	{
		//It will Click on Login button
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		
		//Will sleep for 3 seconds
		Thread.sleep(3000);
		
		//To enter User ID
		driver.findElement(By.xpath("//input[@name='em']")).sendKeys("dheerajps77@gmail.com");
		
		//To enter password
		driver.findElement(By.xpath("//input[@name='pw1']")).sendKeys("India@123");
		
		//Click on Login button
		driver.findElement(By.xpath("//button[@type='button']")).click();
		
		
		//String CurrentResult=driver.findElement(By.xpath("//div[contains(text(),'Hi, I have got an where i needs')]")).getText();
		WebElement ReviewText=driver.findElement(By.xpath("//div[contains(text(),'Hi, I have got an where i needs')]"));
//		
//		String ExpectedResult="Hi, I have got an where i needs assignment to wrie few lines "
//				+ "of code for couple of modules in the walletHub site. "
//				+ "I feel very nice while browsing the site because the "
//				+ "site is good and very handy to use.";
		
		//Using assertion to comparing the results
//		Assert.assertEquals(CurrentResult, ExpectedResult);
//		System.out.println("The current result is matched with expected. So test cases has been passed now");
		
		Assert.assertTrue(ReviewText.isDisplayed());
		System.out.println("Conguratulation !!!!!!. Test case has been passed");
		
		Thread.sleep(3000);
	}
	
	@AfterClass
	public void CloseBroswer()
	{
		driver.close();
	}

}
