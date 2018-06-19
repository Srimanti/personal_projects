package flipkartPageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ItemDetailsPage {

	WebDriver driver;
	
	public ItemDetailsPage(WebDriver driver1){
	
	this.driver = driver1;
	PageFactory.initElements(driver1, this);
	}
	
	@FindBy(xpath= "//a[@class='_2_26Ng _5FnwXU']")
	public List<WebElement> size;
	
	@FindBy(xpath="//button[@class='_2AkmmA _2Npkh4 _2MWPVK']")
	public WebElement addToCart;
	
	@FindBy(xpath= "//button[@class='_2AkmmA _2Npkh4 _2MWPVK RpigiU']")
	public WebElement buy;
	
    public String selectSize(int itemSize) {
		
	try{
		size.get(itemSize).click();
		return("Success");
	}
	catch(Exception e){
		return("Cause of failue" +e.getCause());
	}
	
}
		
		public String AddToCart() {
			
		try{
		addToCart.click();
		return("Success");
		
		}catch (Exception e) {
		
			buy.click();
			return("Cause of failure" +e.getCause());
		}
	}
	
}
