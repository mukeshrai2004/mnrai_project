package login_pkg;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class testlogin {
	WebDriver driver;
	
	@BeforeMethod
	public void setup()
	{
		//System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@Test
	public void verifytitle() throws InterruptedException
	{
		driver.get("https://practicetestautomation.com/practice-test-login/");
		WebElement username=driver.findElement(By.id("username"));
		WebElement password=driver.findElement(By.id("password"));
		WebElement login=driver.findElement(By.id("submit"));
		username.sendKeys("student");
		password.sendKeys("Password123");
		login.click();
		
		String actualUrl = "https://practicetestautomation.com/logged-in-successfully/";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(expectedUrl,actualUrl);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[contains(@class,'wp-block-button')]//a")).click();
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.close();
		driver.quit();
	}
}
