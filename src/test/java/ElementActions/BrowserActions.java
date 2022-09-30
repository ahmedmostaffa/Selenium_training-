package ElementActions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BrowserActions {
	
	public static WebDriver driver;
	public BrowserActions() {
		throw new IllegalStateException("Utility class");
	}
	
	public  static void openLink(WebDriver driver,By locator) {

	     WebElement elem=driver.findElement(locator);
	     String ch=Keys.chord(Keys.CONTROL,Keys.ENTER);
	     elem.sendKeys(ch);
	     
	     
	}
	public static  void clickAlert(WebDriver driver,By locator) {
		
		driver.findElement(locator).click();    
	}
	public static void main(String[] args) {
			BrowserActions browser=new BrowserActions();
	}
	
}
