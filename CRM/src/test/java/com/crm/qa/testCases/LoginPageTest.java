package com.crm.qa.testCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homepage;
	
	public LoginPageTest() {
		super(); //It will call constructor of TestBase class for initialization method. And it will not throw null point exception.
		
	}
	
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage(); //Object of LoginPage class.
		
	}
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		
		String title= loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Free CRM software in the cloud powers sales and customer service");
	}
	

	@Test(priority=2)
	public void crmLogoImageTest() {
		
		Boolean flag=loginPage.validateCRMLogoImage();
		Assert.assertTrue(flag);
	}
	

	@Test(priority=3)
	public void loginTest() {
		homepage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		//Additional added
		
		List<WebElement> links=driver.findElements(By.tagName("a"));
		int totalLinks=links.size();
		System.out.println("The total no. of links available on the page are=="+totalLinks);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}

}
