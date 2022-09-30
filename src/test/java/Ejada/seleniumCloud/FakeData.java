package Ejada.seleniumCloud;

import java.util.Locale;

import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import org.testng.Assert;

public class FakeData {
	public static void main(String[] args) {
		 FakeValuesService fakeValuesService = new FakeValuesService(new Locale("de"), new RandomService());
		    String nationalID = fakeValuesService.numerify("1#########");
		    String iqammaID =fakeValuesService.numerify("2#########");
		    System.out.println("National ID is: " + nationalID);
		    System.out.println("National ID is: " + iqammaID);
			Assert.assertEquals("التسيل","التسجيل");

		
	}

}
