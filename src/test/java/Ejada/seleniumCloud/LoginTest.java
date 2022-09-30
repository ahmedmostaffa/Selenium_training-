package Ejada.seleniumCloud;





import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
	public static WebDriver driver;
	public static Logger log = LogManager.getLogger();
	
	
	@BeforeMethod
	public void SetUp() {

			WebDriverManager.chromedriver().setup();
			log.info("initialize chrome driver");
			log.warn("dadad");
			log.info("Run tests in '"+System.getProperty("browserGlobal")+"'");
			
			driver= new ChromeDriver();
		
		
		
    	// load login page 
		driver.manage().window().maximize();
		driver.navigate().to("https://www.saucedemo.com/");
		log.info("navigate to the saucedemo url");
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Test(description="login with valid credentials ")
	public void loginValidInput() throws InterruptedException {
		
		WebElement user=driver.findElement(By.cssSelector("input#user-name"));
		driver.findElement(By.cssSelector("input#user-name")).sendKeys("standard_user");
		  Shutterbug.shootPage(driver,Capture.FULL)
          .save();

		  
		driver.findElement(By.cssSelector("input#password")).sendKeys("secret_sauce"+Keys.RETURN);
		/* Not a good programming practice, added for demonstration */
		//Thread.sleep(3000);
		// assert or check the JavaScript for beginners is visible 
		String pageHeader=driver.findElement(By.cssSelector("span.title")).getText();
		Assert.assertEquals("PRODUCTS", pageHeader);
		Shutterbug.shootPage(driver, Capture.FULL_SCROLL).save();

	      
		
	}
	
	
	@AfterMethod
    public void tearDown(){
    	driver.quit();
    	
    }
}

