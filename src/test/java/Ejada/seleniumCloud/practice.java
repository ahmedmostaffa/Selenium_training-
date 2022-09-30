package Ejada.seleniumCloud;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.startsWith;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class practice {
	/*
	@Test
	public void matchTest() {

		try {
			assertThat("ejdacoretestautomation", allOf(startsWith("ej"), containsString("aut")));
		} catch (AssertionError e) {
			System.out.println("assert");
		} catch (Exception e) {
			e.fillInStackTrace();
		}

	}
	@Test
	public void arrayMatchTest()
	{
		// resolve case CRM
		
		List<String> DDL = Arrays.asList("Information provided","problem solved");
		assertThat(DDL, containsInAnyOrder("problem solved","Information provided"));
		assertThat(DDL,hasSize(2));
		assertThat(DDL,hasItems("problem solved"));
		assertThat(DDL,hasItem("Information provided"));
		//assertThat("problem", isIn(DDL));
		
	}
	
	@Test
	public void softAssertion()
	{
		// resolve case CRM
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(true, false);
		softAssert.assertEquals(true, true);
		softAssert.assertAll();
	}
	*/
	@Test
	public void AssertJ()
	{
		List<String> DDL = Arrays.asList("cairo","alex","finalnd","itlay","france","spain");
		// resolve case CRM
		assertThat(DDL)
					   .hasSize(5)
				       .startsWith("cairo")
			           .containsAll(DDL)
			           .doesNotContain(null);
		
	}
	@Test
	public static void practiceTest(){
		System.out.println(String.valueOf(Instant.now().getEpochSecond()));
	}

}
