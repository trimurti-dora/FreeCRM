package com.crm.qa.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;
//import com.crm.qa.util.TestUtil;
import com.crm.qa.pages.HomePage;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	public HomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage = new HomePage();
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest(){
		Assert.assertEquals(homePage.verifyHomePageTitle(), "CRMPRO");
	}
	
	@Test(priority=2)
	public void verifyUserNameTest(){
		TestUtil.switchFrame();
		Assert.assertTrue(homePage.verifyUserName());
	}
	
	@Test(priority=3)
	public void clickContactsLinkTest(){
		TestUtil.switchFrame();
		contactsPage= homePage.clickOnContactsLink();
	}
	
	@AfterMethod
	public void tearDown(){
		driver.close();
	}
}
