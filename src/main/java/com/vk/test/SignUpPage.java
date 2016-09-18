package com.vk.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SignUpPage extends StartPage {
	@FindBy(how = How.XPATH, using = "//input[@id='join_phone']")
	public WebElement fieldJoinPhone;
	
	@FindBy(how = How.XPATH, using = "//a[@id='top_reg_link']")
	public WebElement logOut;

	public void logOut() {
		logOut.click();
	}

	public SignUpPage(WebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
	}

}
