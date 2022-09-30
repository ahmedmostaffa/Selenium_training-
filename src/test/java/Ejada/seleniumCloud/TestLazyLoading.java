package Ejada.seleniumCloud;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestLazyLoading {

	@Test
	public void testLazyLoading() {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		
		driver= new ChromeDriver();
		driver.get("https://www.chaijs.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.linkText("Guide")).click();
		
		System.out.println(driver.getTitle());
		driver.findElement(By.linkText("API")).click();
		
		LazyLoading.waitForLazyLoading(driver);
		System.out.println(driver.getTitle());
		driver.quit();
		
		
		
	}
}
