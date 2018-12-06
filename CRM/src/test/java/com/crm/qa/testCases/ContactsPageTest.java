package com.crm.qa.testCases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	public ContactsPageTest() {
		super(); //It will call constructor of TestBase class for initialization method. And it will not throw null point exception.
		
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage(); //Object of LoginPage class.
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		testUtil=new TestUtil();
		testUtil.switchToFrame();
		
		contactsPage=homePage.clickOnContacts();//To click on Contacts tab.
		
	}
	
	@Test(priority=1)
	public void verifyContactsPageLabel() {
		
		Assert.assertTrue(contactsPage.verifyContactsLabel(), "Contatcs label is missing on the page");
	}
	
	@Test(priority=2)
	public void selectContactText() {
		
		contactsPage.selectContactsByName("Test Java");
	}
	
	@Test(priority=3)
	public void selectMultipleContactText() {
		
		contactsPage.selectContactsByName("Test Java");
		contactsPage.selectContactsByName("ATP 1");
	}
	
	
	//Part4===>> For data driven
	@DataProvider
	public void getTestData() {
		
	}
	
	
	
	@Test(priority=4)
	public void validateCreateNewContact() {
		
		homePage.clickOnNewContactLink();
		contactsPage.createNewContact("Mr.", "Tom", "Smith", "Google");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
