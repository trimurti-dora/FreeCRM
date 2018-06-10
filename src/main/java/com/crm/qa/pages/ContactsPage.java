package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class ContactsPage extends TestBase{
	//Object Repository
	@FindBy(xpath="//td[contains(text(), 'Contacts')]")
	WebElement contactLabel;
	
	@FindBy(xpath="//a[contains(text(), 'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(), 'New Contact')]")
	WebElement newContactLink;
	
	@FindBy(id="first_name")
	WebElement firstName;
	
	@FindBy(id="surname")
	WebElement lastName;
	
	@FindBy(name="client_lookup")
	WebElement company;
	
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement saveBtn;
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions or Methods
	public boolean verifyContactsLabel() {
		TestUtil.waitTwoSecond();
		return contactLabel.isDisplayed();
	}
	
	public void selectContactsByName(String name) {
		TestUtil.waitTwoSecond();
		driver.findElement(By.xpath("//a[contains(text(), '"+name+"')]//parent::td//preceding-sibling::td/input[@type='checkbox']")).click();
	}
	
	public void createNewContact(String title, String fName, String lName, String comp) {
		Select select = new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		company.sendKeys(comp);
		saveBtn.click();
	}
	
	public void clickOnNewContactLink() {
		Actions action= new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		TestUtil.waitTwoSecond();
		action.moveToElement(newContactLink).click().build().perform();
		//newContactLink.click();
		
	}
}
