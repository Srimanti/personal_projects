package flipkart;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Flipkart {
	
	    static WebDriver driver = null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		try{
			WebElement cancelLoginButton = driver.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']"));
			cancelLoginButton.click();
			}catch (Exception e) {
				WebElement searchBar = driver.findElement(By.xpath("//input[@title='Search for products, brands and more']"));
				searchBar.click();
			}
		WebElement searchBar = driver.findElement(By.xpath("//input[@title='Search for products, brands and more']"));
		searchBar.click();
		searchBar.sendKeys("jacket");
		WebElement searchButtonClick = driver.findElement(By.xpath("//button[@class='vh79eN']"));
		searchButtonClick.click();
		
		List<WebElement> itemContainer = driver.findElements(By.xpath("//div[@class='_3liAhj _1R0K0g']"));
		WebElement item1 = itemContainer.get(2);
		item1.click();
		
		WebElement item2 = itemContainer.get(3);
		item2.click();
		
		Set<String> openWindows = driver.getWindowHandles();
		List<String> openWindowsList = new ArrayList<String>(openWindows);
		
		driver.switchTo().window(openWindowsList.get(1));
		selectSizeAddCart();
		driver.close();
		
		driver.switchTo().window(openWindowsList.get(2));
		selectSizeAddCart();
		driver.close();
		
		driver.switchTo().window(openWindowsList.get(0));
		driver.navigate().refresh();
		
		WebElement mainCartButton = driver.findElement(By.xpath("//a[@class='_3NFO0d']"));
		mainCartButton.click();
		
		WebElement placeOrder = driver.findElement(By.xpath("//button[@class='_2AkmmA _14O7kc _7UHT_c']"));
		placeOrder.click();
		
		driver.quit();
 	    }
	
		public static void selectSizeAddCart() {
		
			List<WebElement> size = driver.findElements(By.xpath("//a[@class='_2_26Ng _5FnwXU']"));
			size.get(0).click();
			
			try{
			WebElement addToCart = driver.findElement(By.xpath("//button[@class='_2AkmmA _2Npkh4 _2MWPVK']"));
			addToCart.click();
			}catch (Exception e) {
				WebElement buy = driver.findElement(By.xpath("//button[@class='_2AkmmA _2Npkh4 _2MWPVK RpigiU']"));
				buy.click();
			}
			
		}
	
}
