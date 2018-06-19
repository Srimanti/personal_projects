package com.kroakyhub.amazon.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MenuBar {

	WebDriver driver;

	public MenuBar(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.ID, using = "twotabsearchtextbox")
	public WebElement searchBar;

	@FindBy(how = How.XPATH, using = "//input[@type='submit' and @class='nav-input']")
	public WebElement searchButton;

	@FindBy(xpath = "//a[@id='nav-cart']")
	public WebElement navigateToCartButton;

	public String searchForProduct(String product) {
		try {
			searchBar.clear();
			searchBar.sendKeys(product);
			searchButton.click();
			return "Success";
		} catch (Exception e) {
			return ("Failure due to " + e.getCause());
		}
	}

	public String navigateToCart() {
		try {
			navigateToCartButton.click();
			return "Success";
		} catch (Exception e) {
			return ("Failure due to " + e.getCause());
		}
	}

}
