package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase{
	//Object Repository
	@FindBy (xpath= "//*[contains(text(),'User: Naveen K')]")
	WebElement usernameLable;
	
	@FindBy(xpath="//a[contains(text(), 'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(), 'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[contains(text(), 'Tasks')]")
	WebElement tasksLink;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
		
	}
	
	//Actions or Methods
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	public boolean verifyUserName(){
		return usernameLable.isDisplayed();
	}
	public ContactsPage clickOnContactsLink(){
		contactsLink.click();
		return new ContactsPage();
	}
	
	public TasksPage clickOnTasksLink(){
		tasksLink.click();
		return new TasksPage();
	}
	
}
