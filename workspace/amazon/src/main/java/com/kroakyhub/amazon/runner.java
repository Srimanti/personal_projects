package com.kroakyhub.amazon;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.os.WindowsUtils;
import org.openqa.selenium.support.ui.Select;

public class runner {
	
	public static WebDriver driver = null;

	public static void main(String[] args) {
				
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
		
		WebElement searchBar =  driver.findElement(By.id("twotabsearchtextbox"));
		searchBar.click();
	    searchBar.sendKeys("wallet");
		WebElement searchButton = driver.findElement(By.xpath("//input[@type='submit' and @class='nav-input']"));
		searchButton.click();
		
		
		/*WebElement nextTab = driver.findElement(By.xpath("//a[@class= 'a-carousel-goto-nextpage']"));
		WebElement imageContainer = driver.findElement(By.xpath("//img[@alt='oppo f5']"));
		imageContainer.click();*/
				
		
		List<WebElement> itemContainer = driver.findElements(By.xpath("//div[@class='s-item-container']"));
		WebElement item1 = itemContainer.get(4);
		item1.click();
		WebElement item2 = itemContainer.get(5);
		item2.click();
		
		
		Set<String> openWindows = driver.getWindowHandles();
		
		List<String> openWindowList = new ArrayList<String>(openWindows);
				
		driver.switchTo().window(openWindowList.get(1));
				
		addtoCart("3");
		
		driver.close();
		
        driver.switchTo().window(openWindowList.get(2));
             
        addtoCart("2");
        
        driver.close();
        
        driver.switchTo().window(openWindowList.get(0));
        driver.navigate().refresh();
        
        WebElement Buy = driver.findElement(By.xpath("//a[@id='nav-cart']"));
        Buy.click();
        
        WebElement GiftOption = driver.findElement(By.xpath("//input[@id='sc-buy-box-gift-checkbox']"));
        GiftOption.click();
        
        WebElement Checkout = driver.findElement(By.xpath("//input[@name='proceedToCheckout']"));
        Checkout.click();
        
        WebElement loginEmail = driver.findElement(By.xpath("//input[@type='email']"));
        loginEmail.click();
        loginEmail.sendKeys("bit.amit2008@gmail.com");
        
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.click();
        password.sendKeys("Silver12345");
        password.click();
       
        
        WebElement login = driver.findElement(By.xpath("//input[@id='signInSubmit']"));
        login.click();
        
		driver.quit();
		
	}
	
	public static void addtoCart(String quant){
		
		WebElement quantity = driver.findElement(By.xpath("//select[@name='quantity']"));
		Select quantitySelect = new Select(quantity);
		quantitySelect.selectByValue(quant);
		WebElement cart = driver.findElement(By.xpath("//input[@id='add-to-cart-button']"));
		cart.click();
		
	}

}
