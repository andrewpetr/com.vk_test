package com.vk.test;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestAddPostOnWall extends TestBase {

	@BeforeTest
	@Parameters({ "phoneNum", "password" })
	public void beforeTest(String phoneNum, String password) throws Exception {
		webDriver.get("https://vk.com");
		startPage = PageFactory.initElements(webDriver, StartPage.class);
		if (startPage.swithToEnglish.isDisplayed()){
		startPage.swithToEnglish.click();
		Thread.sleep(2000);}
		homePage = startPage.logIn(phoneNum, password);
	}

	@AfterTest
	public void afterTest() {
		Actions action = new Actions(webDriver);
		action.moveToElement(homePage.mouseoverBtn).moveToElement(homePage.delPost).click().build().perform();
		homePage.logOut();
	}

	@Test
	@Parameters({ "post", "My Profile" })
	public void addPostOnMyPage(String post, String nameOfMenu) throws Exception{
		homePage.addPostOnMyPage(post, nameOfMenu);
		Assert.assertEquals(homePage.chekPostedField(post), post, "Post is not correct.");
	}

}
