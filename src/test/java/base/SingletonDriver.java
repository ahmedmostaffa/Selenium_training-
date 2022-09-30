package base;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;



public class SingletonDriver {

	public static WebDriver driver;
	public static final int PAGE_LOAD_TIMEOUT = 20;
	public static final int IMPLICIT_WAIT = 10;
	static Logger log=LogManager.getLogger();
	public static void initiazlize() {
		if(driver==null) {
			var browser="chrome";
			//driver=new DriverFactory().IntitializeDriver("chrome");
		}
		var browser="chrome";
		log.info("intitialize '"+browser+"' driver successfully at"+" "+"Thread"+" "+ Thread.currentThread().getId());
		driver.get("https://www.saucedemo.com/");
		//driver.get("https://www.lambdatest.com/selenium-playground/window-popup-modal-demo");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGE_LOAD_TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
	}
	
	public static void quit() {
		driver.quit();
		driver=null;
	}
}
