package com.crm.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;


public class HomePage extends TestBase{
	public ContactsPage contactsPage;
	public DealsPage dealsPage;
		
	@FindBy(xpath="//td[contains(text(),'User: Ashish Bhalerao')]")
	WebElement userNameLabel;
	
	@FindBy(xpath=".//a[contains(text(), 'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath=".//a[contains(text(), 'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath=".//a[contains(text(), 'Tasks')]")
	WebElement tasksLink;
	
	//Part4 ===>> for Data Driven
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newContactLink;
	
	
	//For every class in com.crm.qa.pages, we need write below 2 methods compulsory.
	//Initializing the page objects:
	//It will automatically call Parent class(TestBase class constructor)then it will call child class constructor to initialize the properties
	public HomePage() {
		PageFactory.initElements(driver, this); //Initializing the page factory and this= current class objects
						
	}
		
	//Actions:
	public String validateHomePageTitle() {
		return driver.getTitle();
//		String title=driver.getTitle();
//		System.out.println("Title of the page after login=="+title);
			
	}
	
	public boolean validateUserLabel() {
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return userNameLabel.isDisplayed();
				
	}
	

	public ContactsPage clickOnContacts() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		contactsLink.click();
		return new ContactsPage();
		
	}
	
	public DealsPage clickOnDeals() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		dealsLink.click();
		return new DealsPage();
		
	}
	
	public TasksPage clickOnTasks() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		tasksLink.click();
		return new TasksPage();
		
	}
	
	//Part4===>> For Data Driven
	public void clickOnNewContactLink() {
		Actions action =new Actions(driver); //For selecting hidden tab/link under a tab.
		action.moveToElement(contactsLink).build().perform();
		
		newContactLink.click();
	}
	
}
