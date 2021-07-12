package stepdefinitions;

import com.pages.HomePage;
import com.pages.ProductPage;
import com.pages.SearchResultsPage;
import com.qa.factory.DriverFactory;
import com.qa.utils.PropertyReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * This class implements the steps which have been
 * mentioned in the search.feature file. 
 * A project ideally will contain multiple implementation files.
 */
public class SearchSteps {
	
	PropertyReader config = new PropertyReader();
	Properties properties = config.readProp();
	
	String browser = properties.getProperty("browser");
	String url = properties.getProperty("url");
	String keyword = properties.getProperty("keyword");
	
	public WebDriver driver;
	public HomePage homePage;
	public ProductPage productPage;
	public SearchResultsPage searchResultsPage;
	
	private static final Logger logger = LogManager.getLogger(SearchSteps.class);
	
	@Before
	public void startBrowser() {
		driver = DriverFactory.init_browser(browser,url);
		homePage = PageFactory.initElements(driver, HomePage.class);
		searchResultsPage = PageFactory.initElements(driver, SearchResultsPage.class);
		productPage = PageFactory.initElements(driver, ProductPage.class);
	}
	
	@Given("user is on the Bunnings home page")
	public void home_page() {
		String homePageTitle = homePage.getTitle();
		logger.info("******** homepageTitle => " + homePageTitle);
		Assert.assertTrue(homePageTitle.contains("Bunnings"));
		WebElement logo = homePage.getLogo();
		Assert.assertTrue(logo.isDisplayed());
	}
	
	@When("user clicks on the search field")
	public void user_clicks_search_field() {
		homePage.clickSearchField();
	}
	
	@Then("a drop-down menu with popular searches is displayed")
	public void popular_searches_menu() {
		WebElement pop_search_menu = homePage.popularSearches();
		Assert.assertTrue(pop_search_menu.isDisplayed());
	}
	
	@When("^user searches for \"(.*)\"$")
	public void product_search(String product) {
		homePage.performSearch(product);
	}
	
	@Then("search results should be displayed to the user")
	public void display_search_results() {
		WebElement results = searchResultsPage.displayResultsPanel();
		Assert.assertTrue(results.isDisplayed());
	}

	@Given("user is on the search results page")
	public void search_results_page() {
		homePage.performSearch(keyword);
		WebElement results = searchResultsPage.displayResultsPanel();
		Assert.assertTrue(results.isDisplayed());
	}
	
	@When("user clicks on any product")
	public void select_product() {
		searchResultsPage.selectProduct();
	}
	
	@Then("user should be redirected to that product page")
	public void product_details_page() {
		WebElement productname = productPage.getProductName();
		Assert.assertTrue(productname.isDisplayed());
		WebElement productImg = productPage.getProductName();
		Assert.assertTrue(productImg.isDisplayed());
	}
	
	@Then("relevant error message should be displayed to the user")
	public void display_results_error() {
		WebElement totalResults = searchResultsPage.displayTotalResults();
		Assert.assertTrue(totalResults.isDisplayed());
		String resultText = totalResults.getText();
		logger.info("****  Total Results === " + resultText);
		Assert.assertEquals(resultText, "We found 0 results for");
	}
	
	@After
	public void closeBrowser() {
		driver.quit();
	}
}
