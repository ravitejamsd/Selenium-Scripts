package kikusearch2ndScenario;
import static org.testng.Assert.assertEquals;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
	@SuppressWarnings("unused")

public class FiltersAndRecommendations {
		WebDriver driver = null;
	    String UrlElement = "https://demo.kiku0101.com/search/";
	    String UserName = "cris";
		String Password = "Test@1234567";
		String sleepTimeString = "3000";
        long sleepTime = Long.parseLong(sleepTimeString);
@Test(priority=0)
    public void LaunchApp() throws Exception {
	System.setProperty("Webdriver.chromedriver", "C:\\Users\\ravit\\Downloads\\chromedriver-win64.zip\\chromedriver-win64\\chromedriver.exe");

	 driver = new ChromeDriver();	
	  driver.manage().window().maximize();
    }
@Test(priority = 1)

public void Sign_in() throws Exception {
    driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
	driver.get(UrlElement);
	Thread.sleep(sleepTime);
	driver.findElement(By.xpath("//button[text()='Login']")).click();
	Thread.sleep(sleepTime);
	driver.findElement(By.xpath("//input[@id='userid']")).sendKeys(UserName);
	Thread.sleep(sleepTime);
	driver.findElement(By.name("password")).sendKeys(Password);
	Thread.sleep(sleepTime);
	driver.findElement(By.xpath("//*[text()='SIGN IN']")).click();
	Thread.sleep(sleepTime);
   }
@Test(priority=2)
   public void FiltersVerify() throws Exception{
    driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//div[text()='All Motion']/child::button")).click();
	Thread.sleep(sleepTime);
	driver.findElement(By.xpath("//div[text()='i80L']//input")).click();
	Thread.sleep(sleepTime);
	WebElement Title = driver.findElement(By.xpath("//div[text()='All Motion']"));
	WebElement FilterIcon = driver.findElement(By.xpath("//*[@data-testid='TipsAndUpdatesIcon']"));
	String ActualText = Title.getText();
	String ExpectedText = "All Motion";
	Assert.assertEquals(ActualText, ExpectedText);
	Thread.sleep(sleepTime);
	FilterIcon.click();
	Thread.sleep(sleepTime);
	Assert.assertFalse(Title.isDisplayed());
	System.out.println(Title.getText());
	FilterIcon.click();
	Thread.sleep(sleepTime);
	Assert.assertTrue(Title.isDisplayed());
	driver.quit();

  }

}