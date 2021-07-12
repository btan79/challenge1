package com.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	private WebDriver driver;
	static long DEFAULT_SLEEP_TIMEOUT = 30;

	private final String logo = "//a[contains(@data-locator,'logo-Bunnings')]";
	private final String search ="//input[@type='search']";
	private final String recentSearch = "//div[contains(@class,'PopularRecentSuggestions')]";
	private final String searchBtn = "//button[contains(@aria-label,'search')]";
	

	@FindBy(xpath=logo)
	WebElement bunningsLogo;
	
	@FindBy(xpath=search)
	WebElement searchField;
	
	@FindBy(xpath=recentSearch)
	WebElement popularSeach;
	
	@FindBy(xpath=searchBtn)
	WebElement searchButton;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public WebElement getLogo() {
		return bunningsLogo;
	}
	
	public void clickSearchField() {
		searchField.click();
	}
	
	public WebElement popularSearches() {
		return popularSeach;
	}
	
	public void performSearch(String keyword) {
		searchField.sendKeys(keyword);
		searchButton.click();
		driver.manage().timeouts().implicitlyWait(DEFAULT_SLEEP_TIMEOUT,TimeUnit.SECONDS);
	}
}
