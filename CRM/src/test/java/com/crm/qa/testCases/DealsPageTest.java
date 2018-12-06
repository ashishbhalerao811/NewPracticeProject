package com.crm.qa.testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class DealsPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	DealsPage dealsPage;
	
	public DealsPageTest() {
		super(); //It will call constructor of TestBase class for initialization method. And it will not throw null point exception.
		
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage(); //Object of LoginPage class.
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		testUtil=new TestUtil();
		testUtil.switchToFrame();
		
		dealsPage=homePage.clickOnDeals(); //To click on Deals tab.;
		
	}
	
	@Test(priority=1)
	public void clickOnDealsType() {
		dealsPage.selectTypeOfDeal();
		
	}

}
