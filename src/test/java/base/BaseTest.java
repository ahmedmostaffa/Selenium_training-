package base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;

import com.applitools.eyes.MatchLevel;
import com.applitools.eyes.selenium.Eyes;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	protected static WebDriver driver;
	protected static Eyes eyes;

	@BeforeTest
	public void SetUp(@Optional("chrome") String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			// ChromeOptions options = new ChromeOptions();
			System.out.println("Run Tests in" + " " + browser);
			driver = new ChromeDriver();
		}
		// initialize applitools eyes
		initializeEyes();
		// load page
		
		driver.manage().window().maximize();
		//driver.get("https://demo.applitools.com/index.html");
		
		//content level
		//driver.get("file:///F:/applitools/automated-visual-testing/website/index.html");
		
		// layout level dynamic contnet
		driver.get("https://the-internet.herokuapp.com/dynamic_content");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@AfterTest
	public void tearDown() {
		driver.quit();
		eyes.abortIfNotClosed();

	}

	// initialize Applitools eyes
	private static void initializeEyes() {
		eyes = new Eyes();
		// API key
		eyes.setApiKey("Wd7dvHmm0ihQFS111kyFIj9gny9GxQgD8ZF5AB00pGav8110");
	}

	protected static void checkWindow() {
		eyes.open(driver, "demo app", "Verification test");
		//eyes.setForceFullPageScreenshot(true);
		eyes.setMatchLevel(MatchLevel.LAYOUT);
		eyes.checkWindow();
		eyes.close();

	}

	protected static void checkElement(By locator) {
		eyes.open(driver, "demo app", "verification test");
		//eyes.setForceFullPageScreenshot(true);
		eyes.setMatchLevel(MatchLevel.LAYOUT);
		eyes.checkElement(locator);
		eyes.close();
	}
}
