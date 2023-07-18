package hashtag.tests;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import hashtag.Joinuspage;
import hashtag.ReuseTestScripts.BaseStep;

public class Joinuspositivetestcase extends BaseStep {

	@Test(priority = 0)
	public void positivetest() throws IOException, InterruptedException {

		String[] value = { "Abi", "diya@gmail.com", "9908765435","I have 2.5 years experience in Testing"};
		page.Joinusfield(value[0], value[1], value[2]);
		Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\src\\fileupload.exe");
		Joinuspage ju = new Joinuspage(driver);
		ju.describe1(value[3]);
		
		JavascriptExecutor js1 = (JavascriptExecutor) driver;		
		js1.executeScript("window.scrollBy(0,500)");		
		ju.Joinusfield2();
		ju.gettext();

	}

	@Test(priority = 1)

	public void negativetest() throws IOException, InterruptedException {
		String[] value1 = { "Abi$$$7  6786", "diyagmail.com", "--990876543756755"};
		page.Joinusfield(value1[0], value1[1], value1[2]);
		Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\src\\fileupload.exe");

		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,500)");
		Joinuspage ju = new Joinuspage(driver);
		ju.Joinusfield2();
		ju.gettext();

	}

}
