package com.vk.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestEmptyField extends TestBase{
	
	@BeforeMethod
	public void beforeTest(){
		webDriver.get("https://vk.com");
		startPage = PageFactory.initElements(webDriver, StartPage.class);
	}
	
	@Test
	public void LoginEmptyFoeld(){
		startPage.logInWithEmptyField();
		Assert.assertTrue(startPage.fieldLogIn.isDisplayed(), "Invalid StartPage.");
	}
	
	@Test
	public void SignupEmptyField(){
		startPage.signUpWithEmptyField();
		Assert.assertTrue(startPage.fieldLogIn.isDisplayed(), "Invalid StartPage.");
	}
	
}
