package Ejada.seleniumCloud;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

import com.applitools.eyes.selenium.Eyes;

import ElementActions.BrowserActions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Test_1 {

	protected static WebDriver driver;
	protected static Eyes eyes;

	@BeforeTest
	public void SetUp(@Optional("chrome") String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();

			System.out.println("Run Tests in" + " " + browser);
			driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		//driver.get("https://demo.applitools.com/index.html");
		
		//content level
		//driver.get("file:///F:/applitools/automated-visual-testing/website/index.html");
		
		// layout level dynamic contnet
		driver.get("https://trytestingthis.netlify.app/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}
	
	@Test
	public void  open_test() {
		By link= By.linkText("Contact");
	
		BrowserActions.openLink(driver,link);
			
	}

}
