package com.vk.test;

import java.util.ArrayList;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestForgotPass extends TestBase {
	private ArrayList<String> newTab;

	@BeforeTest
	public void beforeTest(){
		webDriver.get("https://vk.com");
		startPage = PageFactory.initElements(webDriver, StartPage.class);
		restPass = startPage.restorePass();
		newTab = new ArrayList<String>(webDriver.getWindowHandles());
		webDriver.switchTo().window(newTab.get(1));
	}

	@AfterTest
	public void afterTest() {
		webDriver.close();
		webDriver.switchTo().window(newTab.get(0));
	}

	@Test
	public void loginIncorrect(){
		Assert.assertTrue(restPass.restorePage.isDisplayed(), "Restore password page is not loaded!");
	}

}
