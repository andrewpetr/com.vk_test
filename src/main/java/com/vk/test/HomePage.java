package com.vk.test;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends Page {

	public HomePage(WebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(how = How.XPATH, using = "//div[@id='side_bar_inner']")
	public WebElement leftSideBar;

	@FindBy(how = How.XPATH, using = "//div[@class='top_profile_name']")
	public WebElement nickName;

	@FindBy(how = How.XPATH, using = "//div[@id='side_bar_inner']/ol/li")
	public List<WebElement> listOfLeftSideBar;

	@FindBy(how = How.XPATH, using = "//div[@id='post_field']")
	public WebElement fieldAddPost;

	@FindBy(how = How.XPATH, using = "//button[@id='send_post']")
	public WebElement btnAddPost;

	@FindBy(how = How.XPATH, using = "//div[@class='wall_post_text']")
	public List<WebElement> fieldWallPost;

	@FindBy(how = How.XPATH, using = "//div[@onmouseover='uiActionsMenu.show(this);']/"
			+ "div[contains(@onclick,'uiActionsMenu.keyToggle')]")
	public WebElement mouseoverBtn;

	@FindBy(how = How.XPATH, using = "//a[contains(@onclick,'wall.deletePost')]")
	public WebElement delPost;

	@FindBy(how = How.XPATH, using = "//a[@id='top_profile_link']")
	public WebElement profile;

	@FindBy(how = How.XPATH, using = "//a[@id='top_logout_link']")
	public WebElement logOut;

	@FindBy(how = How.XPATH, using = "//div[@id='profile_online_lv']")
	public WebElement myProfileblock;

	@FindBy(how = How.XPATH, using = "//a[@id='ui_rmenu_news']")
	public WebElement newsblock;

	@FindBy(how = How.XPATH, using = "//a[@id='ui_rmenu_all']")
	public WebElement messagesblock;

	@FindBy(how = How.XPATH, using = "//div[@id='friends']")
	public WebElement friendsblock;

	@FindBy(how = How.XPATH, using = "//button[@id='groups_create_btn']")
	public WebElement communitiesblock;

	@FindBy(how = How.XPATH, using = "//div[@class='photos_albums']")
	public WebElement photoblock;

	@FindBy(how = How.XPATH, using = "//input[@id='audio_search']")
	public WebElement audiosblock;

	@FindBy(how = How.XPATH, using = "//input[@id='video_search_input']")
	public WebElement videosblock;

	@FindBy(how = How.XPATH, using = "//div[@id='apps_search']")
	public WebElement gamesblock;

	public void clickingOnAllLeftSideMenu(String linkOnElementOnLeftSideBar) {
		for (WebElement element : listOfLeftSideBar) {
			if (element.getText().equals(linkOnElementOnLeftSideBar)) {
				element.click();
				break;
			}
		}
	}

	public void addPost(String post) {
		fieldAddPost.sendKeys(post);
		btnAddPost.click();
	}

	public void addPostOnMyPage(String post, String nameOfMenu) throws Exception {
		for (WebElement element : listOfLeftSideBar) {
			if (element.getText().equals(nameOfMenu)) {
				element.click();
				Thread.sleep(2000);
				addPost(post);
				break;
			}
		}
	}

	public String chekPostedField(String post) {
		for (WebElement element : fieldWallPost) {
			if (element.getText().equals(post)) {
				return element.getText();
			} else
				return null;
		}
		return null;
	}

	public void logOut() {
		profile.click();
		logOut.click();
	}

}
