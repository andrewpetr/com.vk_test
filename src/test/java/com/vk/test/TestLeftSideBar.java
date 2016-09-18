package com.vk.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestLeftSideBar extends TestBase {
	@BeforeTest
	@Parameters({ "phoneNum", "password" })
	public void beforeTest(String phoneNum, String password) throws Exception{
		webDriver.get("https://vk.com");
		startPage = PageFactory.initElements(webDriver, StartPage.class);
		if (startPage.swithToEnglish.isDisplayed()){
		startPage.swithToEnglish.click();
		Thread.sleep(2000);}
		homePage = startPage.logIn(phoneNum, password);
	}

	@AfterTest
	public void afterTest() {
		homePage.logOut();
	}

	@Test
	@Parameters({"My Profile"})
	public void clickingOnMenuMyProfile(String myProfile){
		homePage.clickingOnAllLeftSideMenu(myProfile);
		Assert.assertTrue(homePage.myProfileblock.isDisplayed(), "Page My Profile is not loaded.");
	}

	@Test
	@Parameters({"News"})
	public void clickingOnMenuNews(String news){
		homePage.clickingOnAllLeftSideMenu(news);
		Assert.assertTrue(homePage.newsblock.isDisplayed(), "Page News is not loaded.");
	}
	@Test
	@Parameters({"Messages"})
	public void clickingOnMenuMessages(String messages){
		homePage.clickingOnAllLeftSideMenu(messages);
		Assert.assertTrue(homePage.messagesblock.isDisplayed(), "Page Messages is not loaded.");
	}
	@Test
	@Parameters({"Friends"})
	public void clickingOnMenuFriends(String friends){
		homePage.clickingOnAllLeftSideMenu(friends);
		Assert.assertTrue(homePage.friendsblock.isDisplayed(), "Page Friends is not loaded.");
	}
	@Test
	@Parameters({"Communities"})
	public void clickingOnMenuCommunities(String communities){
		homePage.clickingOnAllLeftSideMenu(communities);
		Assert.assertTrue(homePage.communitiesblock.isDisplayed(), "Page Communities is not loaded.");
	}
	@Test
	@Parameters({"Photos"})
	public void clickingOnMenuPhotos(String photos){
		homePage.clickingOnAllLeftSideMenu(photos);
		Assert.assertTrue(homePage.photoblock.isDisplayed(), "Page Photos is not loaded.");
	}
	@Test
	@Parameters({"Audios"})
	public void clickingOnMenuAudios(String audios){
		homePage.clickingOnAllLeftSideMenu(audios);
		Assert.assertTrue(homePage.audiosblock.isDisplayed(), "Page Audios is not loaded.");
	}
	@Test
	@Parameters({"Videos"})
	public void clickingOnMenuVideos(String videos){
		homePage.clickingOnAllLeftSideMenu(videos);
		Assert.assertTrue(homePage.videosblock.isDisplayed(), "Page Videos is not loaded.");
	}
	@Test
	@Parameters({"Games"})
	public void clickingOnMenuGames(String games){
		homePage.clickingOnAllLeftSideMenu(games);
		Assert.assertTrue(homePage.gamesblock.isDisplayed(), "Page Games is not loaded.");
	}
	
}
