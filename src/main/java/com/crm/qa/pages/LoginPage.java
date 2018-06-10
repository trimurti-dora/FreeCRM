package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import com.crm.qa.util.TestUtil;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase{
	//Page Factory/ Page Object Repository
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginBtn;

	@FindBy(xpath="//button[text()='Sign Up']")
	WebElement signUpBtn;
	
	//Initializing Page Objects
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}

	//Actions or Methods
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public HomePage login(String un, String pw){
		username.sendKeys(un);
		password.sendKeys(pw);
		TestUtil.waitTwoSecond();
		loginBtn.click();
		return new HomePage();
	}
	

}
