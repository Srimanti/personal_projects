package com.kroakyhub.amazon.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FinalCart {

WebDriver driver;
	
	public FinalCart(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//input[@id='sc-buy-box-gift-checkbox']")
	public WebElement GiftOption;
	
	@FindBy(xpath="//input[@name='proceedToCheckout']")
	public WebElement Checkout;
	
	
	
}
