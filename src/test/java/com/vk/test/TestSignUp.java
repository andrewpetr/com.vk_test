package com.vk.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestSignUp extends TestBase{
	private String day;
	private String month;
	private String year;
	
	@BeforeTest
	@Parameters({ "firstName", "lastName", "birthDate", "sex" })    
	public void beforeTest(String firstName, String lastName, String birthDate, String sex) throws Exception {
		String str = birthDate;
		String[] tokens = str.split(",");
		this.day = tokens[0];
		this.month = tokens[1];
		this.year = tokens[2];
		webDriver.get("https://vk.com");
		startPage = PageFactory.initElements(webDriver, StartPage.class);
		if (startPage.swithToEnglish.isDisplayed()){
		startPage.swithToEnglish.click();
		Thread.sleep(2000);}
		registrationPage = startPage.signUp(firstName, lastName, day, month, year, sex);
	}
	@AfterTest
	public void aftertest(){
		registrationPage.logOut.click();
	}
	@Test
	public void testSignUp(){
		Assert.assertTrue(registrationPage.fieldJoinPhone.isDisplayed(), "Signup page is not loaded.");
	}
}
