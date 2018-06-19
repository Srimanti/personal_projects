package com.kroakyhub.amazon.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductDetailsPage {

	WebDriver driver;

	public ProductDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//select[@name='quantity']")
	public WebElement quantity;

	@FindBy(xpath = "//input[@id='add-to-cart-button']")
	public WebElement cart;

	public String selectQuantity(String value) {
		try {
			Select quantitySelect = new Select(quantity);
			quantitySelect.selectByValue(value);
			return "Success";
		} catch (Exception e) {
			return ("Failure due to " + e.getCause());
		}
	}

	public String addToCart() {
		try {
			cart.click();
			return "Success";
		} catch (Exception e) {
			return ("Failure due to " + e.getCause());
		}
	}

}
