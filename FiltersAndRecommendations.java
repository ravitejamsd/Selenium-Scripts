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
	assertEquals(ActualText, ExpectedText, "Search Results are Mismatched");
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
/*@Test(priority=3)
public void RecommendationsVerify() throws Exception {
	WebElement element;
	try {
		
	    element = driver.findElement(By.xpath("//*[@data-testid='RecommendIcon']"));
	    element.click();
	} catch (StaleElementReferenceException e) {
		WebElement Title1 = driver.findElement(By.xpath("//h2[text()='1000 Series']"));

	    element = driver.findElement(By.xpath("//*[@data-testid='RecommendIcon']"));
	    element.click();
	Thread.sleep(sleepTime);
	Assert.assertFalse(Title1.isDisplayed());
	System.out.println(Title1.getText());

	}
	Thread.sleep(sleepTime);
	driver.findElement(By.xpath("//*[@data-testid='RecommendIcon']")).click();
	Thread.sleep(sleepTime);
	WebElement Title2 = driver.findElement(By.xpath("//h2[text()='1000 Series']"));
	String ActualTitle = Title2.getText();
	String ExpectedTitle = "1000 Series";
	assertEquals(ActualTitle, ExpectedTitle, "Search Results are Mismatched");
	Assert.assertTrue(Title2.isDisplayed());
	System.out.println(Title2.getText());
	System.out.println("==========================Test Passsed====================");
	Thread.sleep(sleepTime);
	driver.quit();

  }*/

}