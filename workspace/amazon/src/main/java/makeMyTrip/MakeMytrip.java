package makeMyTrip;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MakeMytrip {

	static WebDriver driver = null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		
		driver= new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		WebElement flight = driver.findElement(By.xpath("//a[@class= 'hdr_item_link active']"));
		flight.click();
		
		WebElement fromCity = driver.findElement(By.xpath("//input[@class= 'input_fromto checkSpecialCharacters ui-autocomplete-input']"));
		fromCity.click();
		fromCity.sendKeys("bangalore");
		
		List<WebElement> fromCityList = driver.findElements(By.xpath("//ul[@class= 'ui-autocomplete ui-front ui-menu ui-widget ui-widget-content hp-widget__sfrom']"));
		WebElement city = fromCityList.get(0);
		city.click();
		
		WebElement toCity = driver.findElement(By.xpath("//input[@class= 'input_fromto checkSpecialCharacters ui-autocomplete-input']"));
		toCity.click();
		toCity.sendKeys("goa");
		
		List<WebElement> toCityList = driver.findElements(By.xpath("//ul[@class= 'ui-autocomplete ui-front ui-menu ui-widget ui-widget-content hp-widget__sTo']"));
		WebElement city2 = toCityList.get(0);
		city2.click();
		
		WebElement departureDate = driver.findElement(By.xpath("//input[@class= 'checkSpecialCharacters']"));
		departureDate.click();
		
		List<WebElement> calendar = driver.findElements(By.xpath("//div[@class= 'dateFilter hasDatepicker']/div[@class='ui-datepicker-inline ui-datepicker ui-widget ui-widget-content ui-helper-clearfix ui-corner-all ui-datepicker-multi ui-datepicker-multi-2']//table/tbody/tr/td/a[@class='ui-state-default']"));

		WebElement date = calendar.get(30);
		date.click();
				
		WebElement searchFlight =  driver.findElement(By.xpath("//button[@tabindex = '1']"));
		searchFlight.click();
		
		List<WebElement> chooseFlight = driver.findElements(By.xpath("//div[@class='listing_top clearfix']"));
		WebElement firstFlight = chooseFlight.get(0);
		firstFlight.click();
		
		WebElement clickOnBook = driver.findElement(By.xpath("//a[@class='btn btn-md select_button pull-right hidden-xs btn-primary-red']"));
		clickOnBook.click();
				
				
	}
}
