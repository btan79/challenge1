package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage {

	@SuppressWarnings("unused")
	private WebDriver driver;
	static long DEFAULT_SLEEP_TIMEOUT = 30;
	
	private final String name = "//div[contains(@class,'Grid-container')]/*/h1[contains(@data-locator,'product-title')]";
	private final String image = "//img[contains(@src,'media.prod.bunnings')]";
	
	@FindBy(xpath=name)
	WebElement productName;
	
	@FindBy(xpath=image)
	WebElement productImage;
	
	
	public ProductPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getProductName() {
		return productName;
	}
	
	public WebElement getProductImage() {
		return productImage;
	}
	
}
