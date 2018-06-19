package secretRooster;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SecretRooster {
	
	static WebDriver driver = null;

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://test.roostify.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//Login Page //
		
		WebElement username = driver.findElement(By.xpath("//input[@placeholder='Email']"));
		username.click();
		username.sendKeys("roostify.auto+testborrower@gmail.com");
		
		WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
		password.click();
		password.sendKeys("168Washu");
		
		WebElement SignIn = driver.findElement(By.xpath("//button[@class='btn btn--primary'][@type='submit']"));
		SignIn.click();
		
		// Home Page //
		
		WebElement welcome = driver.findElement(By.xpath("//a[@class= 'nav-item-link'][@data-content='Welcome']"));
		welcome.click();

		WebElement continueDetails = driver.findElement(By.xpath("//button[@name='step'][@value='next']"));
		continueDetails.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));
		WebElement borrower = driver.findElement(By.xpath("//button[contains(text(),'Next')]"));
		borrower.click();
		borrower.click();
		
		
	}

}
