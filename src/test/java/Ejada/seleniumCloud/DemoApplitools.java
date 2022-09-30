package Ejada.seleniumCloud;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;

public class DemoApplitools extends BaseTest{
	
	
	@Test
	public void verificationTest() {
		// assert username exists
		Assert.assertTrue(driver.findElement(By.id("username")) instanceof WebElement);
		
		// assert username placeholder "enter your username"
		Assert.assertEquals(driver.findElement(By.id("username")).getAttribute("placeholder"),"Enter your username");
		
		// assert password exists
		Assert.assertTrue(driver.findElement(By.id("password")) instanceof WebElement);
				
		// assert password placeholder "enter your username"
		Assert.assertEquals(driver.findElement(By.id("password")).getAttribute("placeholder"),"Enter your password");
		
		// assert login button exists
		Assert.assertTrue(driver.findElement(By.id("log-in") )instanceof WebElement);
		
		Assert.assertEquals(driver.findElement(By.id("log-in")).getText(),"Sign in");
		
		// assert check box exists 
		Assert.assertTrue(driver.findElement(By.className("form-check-input")) instanceof WebElement );
		
		Assert.assertEquals(driver.findElement(By.className("form-check-label")).getText(), "Remember Me");
				
		// assert  logo exists
		Assert.assertTrue(driver.findElement(By.xpath("(//img[1])[1]")) instanceof WebElement );
		
		// assert  twitter exists
		Assert.assertTrue(driver.findElement(By.xpath("(//img[1])[2]")) instanceof WebElement );
		
		// assert  linkedin exists
		Assert.assertTrue(driver.findElement(By.xpath("(//img[1])[3]")) instanceof WebElement );
				
		// assert  facebook exists
		Assert.assertTrue(driver.findElement(By.xpath("(//img[1])[4]")) instanceof WebElement );
		
	}
	

}
