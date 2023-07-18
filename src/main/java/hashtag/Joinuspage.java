package hashtag;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class Joinuspage {
	
	WebDriver driver;
	
	public Joinuspage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(css="input[placeholder='Enter your name']")
	WebElement name;
	
	@FindBy(xpath="//*[@placeholder='Enter your email']")
	WebElement email;
	
	@FindBy(css="[placeholder*='Enter your phone']")
	WebElement phone;
	
	@FindBy(xpath="//div[@class='btn-group form-btn join_us_career']/button[@class='btn form-button font-12 font-bold']")
	
	WebElement applyButton;
	
	
	@FindBy(css="[placeholder='Briefly Describe Yourself']")
	WebElement describe;
		
	public void Joinusfield (String name1, String email1, String phone1) throws InterruptedException, IOException
	{
	
	name.sendKeys(name1);
	email.sendKeys(email1);
	phone.sendKeys(phone1);
	Actions a = new Actions(driver);
	WebElement move = driver.findElement(By.xpath("//*[@class='col-lg-6 col-md-12 col-sm-12 pt-5']/input[@id='inputFile']"));
	a.moveToElement(move).click().build().perform();
	Thread.sleep(3000);

	}
	
	
	public void describe1(String describeBrief)
	{
		describe.sendKeys(describeBrief);
	}
	
	public void Joinusfield2() throws InterruptedException
	{
		Thread.sleep(4000);
		applyButton.click();
	}
	
	public void gettext() throws InterruptedException
	{
	
		Thread.sleep(5000);
		
	String	actual = driver.findElement(By.xpath("//div[@class='col-lg-10 col-md-12 col-sm-12 pt-5']/p[@class='text-danger'][2]")).getText();

	Assert.assertEquals(actual, "something went wrong! please try again later");
	
	}
	
	public void urlPage ()
	{
		driver.get("https://www.hashtag-ca.com/careers/apply?jobCode=QAE001"); 
	}
	
}
  