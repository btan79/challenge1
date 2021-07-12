package com.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPage {

	private WebDriver driver;
	long DEFAULT_SLEEP_TIMEOUT = 30;
	
	private final String panel = "//div[contains(@class,'SearchComponentWrapper')]";
	private final String title = "//a[contains(@class,'ProductTileWrapper')]";
	private final String totalresults = "//div[contains(@class,'totalResults')]";
	
	@FindBy(xpath=panel)
	WebElement resultsPanel;
	
	@FindBy(xpath=title)
	WebElement productTile;
	
	@FindBy(xpath=totalresults)
	WebElement totalResults;
	
	public SearchResultsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement displayResultsPanel() {
		return resultsPanel;
	}
	
	public WebElement displayTotalResults() {
		return totalResults;
	}
	
	public void selectProduct() {
		productTile.click();
		driver.manage().timeouts().implicitlyWait(DEFAULT_SLEEP_TIMEOUT,TimeUnit.SECONDS);
	}
	
}
