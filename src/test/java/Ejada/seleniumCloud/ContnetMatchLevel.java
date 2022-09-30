package Ejada.seleniumCloud;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.BaseTest;

public class ContnetMatchLevel extends BaseTest {
	@Test
	protected void verificationTest() {
		driver.findElement(By.id("searchBar")).sendKeys("Agile");
		checkWindow();
	}
	

}
