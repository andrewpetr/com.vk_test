package com.vk.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.vk.webdriver.WebDriverFactory;

public class TestBase
{
	protected static WebDriver webDriver;
	protected StartPage startPage; 
	protected HomePage homePage;
	protected RestorePassPage restPass;
	protected SignUpPage registrationPage;

	@BeforeSuite
	@Parameters({ "browserName"})
	public void beforeSuite(String browserName) throws Exception {
		webDriver = WebDriverFactory.getInstance(browserName);
		webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		webDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		webDriver.manage().window().maximize();
	}

	@AfterSuite
	public void afterSuite() throws Exception {
		if (webDriver != null) {
			WebDriverFactory.killDriverInstance();
		}
	}

}
