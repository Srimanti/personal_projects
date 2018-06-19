package flipkartPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FinalCheckoutPage {

	WebDriver driver;
	public FinalCheckoutPage(WebDriver driver1){
		
		this.driver = driver1;
		PageFactory.initElements(driver1, this);
	}
	
	@FindBy(xpath= "//button[@class='_2AkmmA _14O7kc _7UHT_c']")
	WebElement placeOrder;
	
	public String clickPlaceOrder(){
		try{
			placeOrder.click();
			return("Success");
		}
		
		catch(Exception e){
			return("Cause of Failure" +e.getCause());
		}
		
	}
}
