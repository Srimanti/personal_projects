package com.kroakyhub.amazon.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductResultPage {

	WebDriver driver;

	public ProductResultPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='s-item-container']")
	public List<WebElement> itemContainer;

	public String clickOnProduct(int productNumber) {
		try {
			itemContainer.get(productNumber - 1).click();
			return "Success";
		} catch (Exception e) {
			return "Failure due to " + e.getCause();
		}
	}

}
