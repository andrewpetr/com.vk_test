package com.vk.test;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class StartPage extends Page{


	public StartPage(WebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(how = How.XPATH, using = "//input[@id='index_email']")
	public WebElement fieldLogIn;

	@FindBy(how = How.XPATH, using = "//input[@id='index_pass']")
	public WebElement fieldPass;

	@FindBy(how = How.XPATH, using = "//button[@id='index_login_button']")
	public WebElement btnLogIn;

	@FindBy(how = How.XPATH, using = "//div[@class='forgot']")
	public WebElement linkForgotPass;

	@FindBy(how = How.XPATH, using = "//input[@id='ij_first_name']")
	public WebElement fieldFirstName;

	@FindBy(how = How.XPATH, using = "//input[@id='ij_last_name']")
	public WebElement fieldLastName;

	@FindBy(how = How.XPATH, using = "//td[@id='dropdown1']")
	public WebElement selectDay;

	@FindBy(how = How.XPATH, using = "//div[@class='ij_bday']//input[@id='selectedItems']")
	public WebElement selectedDay;

	@FindBy(how = How.XPATH, using = "//td[@id='dropdown2']")
	public WebElement selectMounth;

	@FindBy(how = How.XPATH, using = "//div[@class='ij_bmonth']//input[@id='selectedItems']")
	public WebElement selectedMonth;

	@FindBy(how = How.XPATH, using = "//td[@id='dropdown3']")
	public WebElement selectYear;

	@FindBy(how = How.XPATH, using = "//div[@class='ij_byear']//input[@id='selectedItems']")
	public WebElement selectedYear;

	@FindBy(how = How.XPATH, using = "//div[@id='ij_sex_row']/div")
	public List<WebElement> selectSex;

	@FindBy(how = How.XPATH, using = "//button[@id='ij_submit']")
	public WebElement btnSignUp;

	@FindBy(how = How.XPATH, using = "//div[@class='ij_bday']//li")
	public List<WebElement> listOfDays;

	@FindBy(how = How.XPATH, using = "//div[@class='ij_bmonth']//li")
	public List<WebElement> listOfMonths;

	@FindBy(how = How.XPATH, using = "//div[@class='ij_byear']//li")
	public List<WebElement> listOfYears;

	@FindBy(how = How.XPATH, using = "//a[@id='top_switch_lang']")
	public WebElement swithToEnglish;

	public void fieldLogIn(String phone) {
		fieldLogIn.sendKeys(phone);
	}

	public void fieldPass(String pass) {
		fieldPass.sendKeys(pass);
	}

	public HomePage logIn(String phoneOrEmail, String pass) {
		fieldLogIn(phoneOrEmail);
		fieldPass(pass);
		btnLogIn.click();
		return PageFactory.initElements(webDriver, HomePage.class);
	}

	public StartPage logInWithEmptyField() {
		btnLogIn.click();
		return PageFactory.initElements(webDriver, StartPage.class);
	}

	public StartPage signUpWithEmptyField() {
		btnSignUp.click();
		return PageFactory.initElements(webDriver, StartPage.class);
	}

	public RestorePassPage restorePass() {
		linkForgotPass.click();
		return PageFactory.initElements(webDriver, RestorePassPage.class);
	}

	public SignUpPage signUp(String firstName, String lastName, String day, String month, String year, String sex) {
		registrationFill(firstName, lastName, day, month, year, sex);
		btnSignUp.click();
		return PageFactory.initElements(webDriver, SignUpPage.class);
	}

	public void registrationFill(String firstName, String lastName, String day, String month, String year, String sex) {
		fieldFirstName.sendKeys(firstName);
		fieldLastName.sendKeys(lastName);
		setSex(sex);
		setBrthDate(day, month, year);
	}

	private void setSex(String sex) {
		int s = Integer.parseInt(sex);
		if (s == 0)
			selectSex.get(1).click();
		else
			selectSex.get(2).click();
	}

	private void setBrthDate(String day, String month, String year) {
		selectDay.click();
		for (WebElement element : listOfDays) {
			if (element.getAttribute("val").equals(day)) {
				element.click();
				break;
			}
		}
		selectMounth.click();
		for (WebElement element : listOfMonths) {
			if (element.getAttribute("val").equals(month)) {
				element.click();
				break;
			}
		}
		selectYear.click();
		for (WebElement element : listOfYears) {
			if (element.getAttribute("val").equals(year)) {
				element.click();
				break;
			}
		}
	}

	public boolean verifySelectedSex() {
		for (WebElement element : selectSex) {
			if (element.isSelected())
				break;
			return true;
		}
		return false;
	}
}