package flipkartPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	
	public HomePage(WebDriver driver1)
	{
		this.driver= driver1;
		PageFactory.initElements(driver1, this);
	}
	
	@FindBy(xpath = "//input[@type='text' and @title='Search for Products, Brands and More']")
	WebElement searchBar;
	
	@FindBy(xpath = "//button[@class='vh79eN']")
	WebElement searchButtonClick;
	
	@FindBy(xpath= "//a[@class='_3NFO0d']")
	WebElement mainCartButton;
	
	public String productSearch(String product){
		try{
			searchBar.clear();
			searchBar.sendKeys();
			searchBar.click();
			return("Success");
			}
		catch (Exception e){
			
		return("Failure due to" +e.getCause());
		}
		}
		
	public String goToCart()
	{
		try{
			searchButtonClick.click();
			return("Success");			
		}
		catch (Exception e) {
			return("Failure due to" +e.getCause());
		}
	}
	
	
}
