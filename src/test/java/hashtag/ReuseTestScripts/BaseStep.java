package hashtag.ReuseTestScripts;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import hashtag.Joinuspage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseStep {

	public WebDriver driver;
	public Joinuspage page;
	
	public WebDriver browserinvoke() throws IOException
	
	{
		
		Properties pro = new Properties();
		FileInputStream is = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\hashtag\\global\\GlobalData.properties");
		pro.load(is);
		String brow1 = pro.getProperty("browser");
		
		if(brow1.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup(); 

			driver = new ChromeDriver();
		}
		else if (brow1.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup(); 

			driver = new FirefoxDriver();
		}
		else if (brow1.equalsIgnoreCase("edge"))
		{
			WebDriverManager.firefoxdriver().setup(); 

			driver = new EdgeDriver();
		}
		

		driver.manage().window().maximize(); 

		driver.getTitle(); 

		driver.getCurrentUrl(); 
		return driver;
	}
	
	@BeforeMethod
	public Joinuspage browserinvokelaunch() throws IOException
	{
		driver =browserinvoke(); 
		 page = new Joinuspage(driver);
    	page.urlPage();
    	return page;
    	
	}
	
	@AfterMethod
	public void close()
	{
		driver.close();
	}
}
