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
import org.openqa.selenium.Keys;

public class LoginTest {
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
	public void loginValidInput() throws InterruptedException {
		
		
		driver.findElement(By.cssSelector("input#user-name")).sendKeys("standard_user");
		driver.findElement(By.cssSelector("input#password")).sendKeys("secret_sauce"+Keys.RETURN);
		
		// assert or check the JavaScript for beginners is visible 
		String pageHeader=driver.findElement(By.cssSelector("span.title")).getText();
		
		Assert.assertEquals("Products", pageHeader);
		/* Not a good programming practice, added for demonstration */
		//Thread.sleep(5000);
	}
	
	
	@AfterMethod
    public void tearDown(){
    	driver.quit();
    	
    }
}

