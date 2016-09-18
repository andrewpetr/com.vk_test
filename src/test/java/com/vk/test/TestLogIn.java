package com.vk.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestLogIn extends TestBase {

	@BeforeMethod
	public void beforeMethod(){
		webDriver.get("https://vk.com");
		startPage = PageFactory.initElements(webDriver, StartPage.class);
	}
	
	@AfterMethod
	public void afterMethod(){
		homePage.logOut();
	}

	@Test
	@Parameters({ "phoneNum", "password", "userName" })
	public void loginWithPhone(String phoneNum, String password, String userName){
		homePage = startPage.logIn(phoneNum, password);
		Assert.assertEquals(homePage.nickName.getText(), userName, "Login with phone number is not complite.");
	}
	
	@Test
	@Parameters({ "email", "password", "userName" })
	public void loginWithEmail(String email, String password, String userName){
		homePage = startPage.logIn(email, password);
		Assert.assertEquals(homePage.nickName.getText(), userName, "Login with email is not complite");
	}
}
