package com.qa.factory;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.SystemUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {
	
	private static final Logger logger = LogManager.getLogger(DriverFactory.class);

	private static WebDriver driver = null;
	private static String geckoDriverPathWindows = "src/main/resources/geckodriver/windows/geckodriver.exe";
	private static String geckoDriverPathMacOs = "src/main/resources/geckodriver/macos/";
	static long DEFAULT_SLEEP_TIMEOUT = 30;
	
	/* This method is used to initialize the browser driver for a given browser */
	public static WebDriver init_browser(String browser, String url) {
		String driverLocation = "";
		logger.info("*******  Current browser => " + browser);
		
		if (SystemUtils.IS_OS_WINDOWS) {
			logger.info("Operating System detected was Windows.");
			logger.info("Loading Gecko driver from => " + geckoDriverPathWindows);
			driverLocation = (new File(geckoDriverPathWindows).getAbsolutePath()).replace("\\", "\\\\");
		} else if (SystemUtils.IS_OS_MAC) {
			logger.info("Operating System detected was MacOS.");
			logger.info("Loading Gecko driver from => " + geckoDriverPathMacOs);
			//driverLocation =  //TODO: To be implemented.
		} else {
			logger.info("Operating System detected is not supported.");
		}
		
		logger.info("*******  driver location => " + driverLocation);
		System.setProperty("webdriver.gecko.driver", driverLocation);
		
		if(browser == null) {
			logger.info("Please choose a browser to test. Current browser => " + browser);
		}
		else {
			switch(browser.toLowerCase()) {
			case "chrome":
				driver = new ChromeDriver();
				break;
			case "firefox":
				driver = new FirefoxDriver();
				break;
			case "safari":
				driver = new SafariDriver();
				break;
			default:
				driver = new FirefoxDriver();
			}
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(DEFAULT_SLEEP_TIMEOUT,TimeUnit.SECONDS);
			return driver;
		}
		return driver;
	}
}
