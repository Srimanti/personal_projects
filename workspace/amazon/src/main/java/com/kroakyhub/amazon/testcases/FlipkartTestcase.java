package com.kroakyhub.amazon.testcases;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import flipkartPageObjects.FinalCheckoutPage;
import flipkartPageObjects.HomePage;
import flipkartPageObjects.ItemDetailsPage;
import flipkartPageObjects.ProductViewPage;

public class FlipkartTestcase {
	
		
	WebDriver driver = null;
	@BeforeTest
		public void setup() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		}

	@BeforeMethod
	public void openFlipkart(){
	driver.get("https://www.flipkart.com/");
	
		}

	@Test
	public void testCase(){
		
		HomePage homePage = new HomePage(driver);		
		ProductViewPage productView = new ProductViewPage(driver);
		ItemDetailsPage itemDetails = new ItemDetailsPage(driver);
		FinalCheckoutPage finalCheckout = new FinalCheckoutPage(driver);
		
				
		homePage.productSearch("Jacket");
		
		productView.clickOnProduct(4);
		
		productView.clickOnProduct(5);
		
		Set<String> openWindows = driver.getWindowHandles();
		List<String> openWindowsList = new ArrayList<String>(openWindows);
		
		driver.switchTo().window(openWindowsList.get(1));
		
		itemDetails.selectSize(0);
		
		itemDetails.AddToCart();
		driver.close();
		
		driver.switchTo().window(openWindowsList.get(2));
		
		itemDetails.selectSize(0);
		
		itemDetails.AddToCart();
		driver.close();
		
		driver.switchTo().window(openWindowsList.get(0));
		driver.navigate().refresh();
		
		finalCheckout.clickPlaceOrder();
		
	}		
	/*WebElement searchBar = driver.findElement(By.xpath("//input[@type='text' and @title='Search for Products, Brands and More']"));
	searchBar.click();
	searchBar.sendKeys("jacket");
	WebElement searchButtonClick = driver.findElement(By.xpath("//button[@class='vh79eN']"));
	searchButtonClick.click();
	
	List<WebElement> itemContainer = driver.findElements(By.xpath("//div[@class='_3liAhj']"));
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
	}
	
	@Test
	public void testCase(){
		
	WebElement searchBar = driver.findElement(By.xpath("//input[@type='text' and @title='Search for Products, Brands and More']"));
	searchBar.click();
	searchBar.sendKeys("jacket");
	WebElement searchButtonClick = driver.findElement(By.xpath("//button[@class='vh79eN']"));
	searchButtonClick.click();
	
	List<WebElement> itemContainer = driver.findElements(By.xpath("//div[@class='_3liAhj']"));
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
	}
	
	public void selectSizeAddCart() {
		
		List<WebElement> size = driver.findElements(By.xpath("//a[@class='_2_26Ng _5FnwXU']"));
		size.get(0).click();
		
		try{
		WebElement addToCart = driver.findElement(By.xpath("//button[@class='_2AkmmA _2Npkh4 _2MWPVK']"));
		addToCart.click();
		}catch (Exception e) {
			WebElement buy = driver.findElement(By.xpath("//button[@class='_2AkmmA _2Npkh4 _2MWPVK RpigiU']"));
			buy.click();
		}
	}*/
		
		@AfterTest
		
		public void endTestcase() {
		driver.quit();
		}
}
