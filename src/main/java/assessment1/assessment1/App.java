package assessment1.assessment1;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;
 
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws  AWTException  
    {
    	System.setProperty("webdriver.chrome.driver","c:\\chromedriver.exe");
		 
		  ChromeOptions op = new ChromeOptions();
		  op.addExtensions(new File("C:\\leadiqext.crx"));
		  DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		  capabilities.setCapability(ChromeOptions.CAPABILITY, op);
		  op.merge(capabilities);
		 
    	
		WebDriver driver=new ChromeDriver(capabilities);
		 driver.manage().window().maximize();
	 	driver.navigate().to("https://account.leadiq.com/app/signup/?referralCode=goneprospectin");
		
		
		  try { 
			  Thread.sleep(7000);
		  
		  
		  driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Anshuman");
		  driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("chauhan"); 
		  driver.findElement(By.xpath("//input[@type='email']")).sendKeys("anshumanchauhan.05@mbc.com");
		  driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("individ");
		  driver.findElement(By.xpath("//input[@type='password']")).sendKeys("#Ac12345");
		  driver.findElement(By.xpath("(//input[@type='password'])[2]")).sendKeys("#Ac12345");
		  driver.findElement(By.xpath("//span/span")).click();
		  driver.findElement(By.xpath("//div/div/div/div")).click();
		  Thread.sleep(7000);
		  
		  
		  
		  
		  
		  driver.get(" https://account.leadiq.com/extension/leadiq-app.html");
		  
		  
		  
		  Robot robot = new Robot();
		  robot.keyPress(KeyEvent.VK_CONTROL);
		  robot.keyPress(KeyEvent.VK_T);
		  robot.keyRelease(KeyEvent.VK_CONTROL);
		  robot.keyRelease(KeyEvent.VK_T);
		  
		  String parent =driver.getWindowHandle();
		  
		  ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		  driver.switchTo().window(tabs.get(1));
		 
		
		 driver.get("https://www.linkedin.com/login?fromSignIn=true&trk=guest_homepage-basic_nav-header-signin");
		
		driver.findElement(By.id("username")).sendKeys("anshuman.chauhan05@gmail.com"); 
		driver.findElement(By.id("password")).sendKeys("#Ac855909");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		//Thread.sleep(8000);
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='feed-identity-module profile-rail-card container ember-view']//div//a[@href])[1]")));

		driver.findElement(By.xpath("(//div[@class='feed-identity-module profile-rail-card container ember-view']//div//a[@href])[1]")).click();
		
		Thread.sleep(5000);
		driver.switchTo().window(parent);
		Thread.sleep(45000);
		driver.findElement(By.cssSelector(".iq-button")).click();
		driver.findElement(By.className("view-button")).click();
		driver.get("https://account.leadiq.com/app/campaigns/all/");
		
		
		}
		 catch(Exception e)
		  {
			  
		  }
    }
}