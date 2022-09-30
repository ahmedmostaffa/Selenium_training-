package Ejada.seleniumCloud;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class LazyLoading {

	public static void waitForLazyLoading(WebDriver driver) {
		boolean pageFullyLoaded = false;
		String pageStatus = null;

		while (!pageFullyLoaded) {
			pageStatus = returnPageStatus(driver);
			System.out.println(pageStatus);
			if (pageStatus.equalsIgnoreCase("complete") || pageStatus.equalsIgnoreCase("interactive")) {
				pageFullyLoaded = true;
			}
		}
		
	}

	public static String returnPageStatus(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String pageStatus = js.executeScript("return document.readyState;").toString();
		return pageStatus;

	}

}
