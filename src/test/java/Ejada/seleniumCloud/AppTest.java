package Ejada.seleniumCloud;




import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.Assert;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Optional;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;

public class AppTest {
	public static WebDriver driver;

	

	@BeforeMethod
	public void SetUp(@Optional("chrome") String browser ) {
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			//ChromeOptions options = new ChromeOptions();
			System.out.println("Run Tests in"+ " "+ browser);
			driver= new ChromeDriver();
		}
		
		if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			//FirefoxOptions options=new FirefoxOptions();
			System.out.println("Run Tests in"+ " "+ browser);
			driver= new FirefoxDriver();
		}
    	// load login page 
		driver.manage().window().maximize();
		driver.navigate().to("https://courses.letskodeit.com/practice");
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    	
	}
	
	@Test(description="handle iframe  ")
	public void test() throws InterruptedException {
		

	
		driver.switchTo().frame(0);
		driver.findElement(By.cssSelector("div.zen-course-list>a")).click(); 
		
		// assert or check the JavaScript for beginners is visible 
		Assert.assertTrue( driver.findElement(By.xpath("//*[@data-zd='zen_cs_desc_promo_title_dynamic']")).isDisplayed());
		/* Not a good programming practice, added for demonstration */
		Thread.sleep(5000);
	}
	
	
	@AfterMethod
    public void tearDown(){
    	driver.quit();
    	
    }
}

