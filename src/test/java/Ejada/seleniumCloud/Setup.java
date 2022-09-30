package Ejada.seleniumCloud;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Setup {
	
	@Parameters({"browser","baseURL"})
    @Test()
	public void setmethod(String browser, String baseURL)
    {
        System.setProperty("browserGlobal",browser);
        System.setProperty("baseURLGlobal",baseURL);
        System.out.println(browser);
        System.out.println(baseURL);
    }

}
