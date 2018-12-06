package com.crm.qa.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	DealsPage dealsPage;
	TasksPage tasksPage;
	
	
	public HomePageTest() {
		super(); //It will call constructor of TestBase class for initialization method. And it will not throw null point exception.
		
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage(); //Object of LoginPage class.
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil=new TestUtil();
		testUtil.switchToFrame();// We can write this step here or in verifyCorrectUserNameLabel() or verifyContactsLinkText() methods.
	}
	
	@Test(priority=1)
	public void verifyHomePageTitelTest() {
		String homePageTitle= homePage.validateHomePageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO", "Home Page title not matched");
		
	}
	
	@Test(priority=2)
	public void verifyCorrectUserNameLabel() {
//		testUtil.switchToFrame();====>> We can write this step here or in setUp() method.
		Assert.assertTrue(homePage.validateUserLabel());
	}
	
	@Test(priority=3)
	public void verifyContactsLinkText() {
//		testUtil.switchToFrame();
		contactsPage= homePage.clickOnContacts();
	
	}
	
//	@Test(priority=4)
//	public void clickOnDealsLink() {
//		testUtil.switchToFrame();
//		dealsPage=homePage.clickOnDeals();
//		
//	}
//	
//	@Test(priority=5)
//	public void clickOnTasksLink() {
//		testUtil.switchToFrame();
//		tasksPage=homePage.clickOnTasks();
//		
//	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
	
	
}
