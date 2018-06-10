package com.crm.qa.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	String sheetName= "contacts";
	public ContactsPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		contactsPage= new ContactsPage();
		homePage= loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		TestUtil.switchFrame();

	}
	
	@Test(enabled=false)
	public void verifyContactLabelTest() {
		contactsPage= homePage.clickOnContactsLink();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		Assert.assertTrue(contactsPage.verifyContactsLabel());
	}
	
	@Test()
	public void selectContactTest(){
		contactsPage= homePage.clickOnContactsLink();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		contactsPage.selectContactsByName("Abhi kum");
		contactsPage.selectContactsByName("Anushka sharma");
	}
	
	@DataProvider
	public Object[][] getContactTestData() {
		Object[][] data= TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(dataProvider="getContactTestData")
	public void validateCreateNewContact(String title, String fName, String lName, String comp) {
		driver.manage().timeouts().pageLoadTimeout(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		contactsPage.clickOnNewContactLink();
		TestUtil.waitTwoSecond();
		contactsPage.createNewContact(title, fName, lName, comp);
	}
	
	@AfterMethod
	public void tearDown(){
		driver.close();
	}
}
