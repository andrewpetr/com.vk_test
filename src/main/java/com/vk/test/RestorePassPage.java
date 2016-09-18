package com.vk.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class RestorePassPage extends StartPage{

	@FindBy(how = How.XPATH, using = "//div[@id='forgot_panel']")
	public WebElement restorePage;

	public RestorePassPage(WebDriver webDriver) {
		super(webDriver);
	}

}
