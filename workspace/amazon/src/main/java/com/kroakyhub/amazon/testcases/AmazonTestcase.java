package com.kroakyhub.amazon.testcases;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.kroakyhub.amazon.pageobjects.MenuBar;
import com.kroakyhub.amazon.pageobjects.ProductDetailsPage;
import com.kroakyhub.amazon.pageobjects.ProductResultPage;

import junit.framework.Assert;

public class AmazonTestcase {

	private WebDriver driver = null;

	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
	}

	@BeforeMethod
	public void gotoAmazon() {
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
	}

	@Test
	public void testcase1() {
		MenuBar menuBar = new MenuBar(driver);
		ProductResultPage productResultPage = new ProductResultPage(driver);
		ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);

		// Searching for Wallets
		Assert.assertEquals(menuBar.searchForProduct("wallets"),"Success");

		// Click on the 5th product
		Assert.assertEquals(productResultPage.clickOnProduct(5),"Success");

		// Click on 6th product
		Assert.assertEquals(productResultPage.clickOnProduct(6),"Success");

		Set<String> openWindows = driver.getWindowHandles();
		List<String> openWindowList = new ArrayList<String>(openWindows);
		driver.switchTo().window(openWindowList.get(1));

		// Select 2 quantity
		Assert.assertEquals(productDetailsPage.selectQuantity("2"),"Success");

		// Add product to cart
		Assert.assertEquals(productDetailsPage.addToCart(),"Success");

		driver.switchTo().window(openWindowList.get(2));

		// Select 2 quantity
		Assert.assertEquals(productDetailsPage.selectQuantity("2"),"Success");

		// Add product to cart
		Assert.assertEquals(productDetailsPage.addToCart(),"Success");
		
		driver.switchTo().window(openWindowList.get(0));
		
		// Navigate to cart
		Assert.assertEquals(menuBar.navigateToCart(),"Success");

	}

	@Test
	public void addToCartTestcase() {
		
		WebElement searchBar = driver.findElement(By.id("twotabsearchtextbox"));
		searchBar.click();
		searchBar.sendKeys("wallet");
		WebElement searchButton = driver.findElement(By.xpath("//input[@type='submit' and @class='nav-input']"));
		searchButton.click();

		List<WebElement> itemContainer = driver.findElements(By.xpath("//div[@class='s-item-container']"));
		WebElement item1 = itemContainer.get(4);
		item1.click();
		WebElement item2 = itemContainer.get(5);
		item2.click();

		Set<String> openWindows = driver.getWindowHandles();
		List<String> openWindowList = new ArrayList<String>(openWindows);

		driver.switchTo().window(openWindowList.get(1));

		addtoCart("1");

		driver.close();

		driver.switchTo().window(openWindowList.get(2));

		addtoCart("1");

		driver.close();

		driver.switchTo().window(openWindowList.get(0));
		driver.navigate().refresh();

		WebElement Buy = driver.findElement(By.xpath("//a[@id='nav-cart']"));
		Buy.click();

		WebElement GiftOption = driver.findElement(By.xpath("//input[@id='sc-buy-box-gift-checkbox']"));
		GiftOption.click();

		WebElement Checkout = driver.findElement(By.xpath("//input[@name='proceedToCheckout']"));
		Checkout.click();
	}

	private void addtoCart(String quant) {

		WebElement quantity = driver.findElement(By.xpath("//select[@name='quantity']"));
		Select quantitySelect = new Select(quantity);
		quantitySelect.selectByValue(quant);
		WebElement cart = driver.findElement(By.xpath("//input[@id='add-to-cart-button']"));
		cart.click();

	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
