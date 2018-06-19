package flipkartPageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductViewPage {

	WebDriver driver;
	
	public ProductViewPage(WebDriver driver1){
		this.driver = driver1;
		PageFactory.initElements(driver1, this);		
	}
	
	@FindBy(xpath= "//div[@class='_3liAhj']")
	List<WebElement> ItemContainer;
	
	public String clickOnProduct(int product){
		
	try{
		WebElement item = ItemContainer.get(product);
		item.click();
		return("Success");
	}
	catch (Exception e){
		return("Casue of failure" +e.getCause());
	}
	}
}
