package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{

	//Page Factory - @FindBy() method
//	//driver.findElement(By.xpath(".//*[@name='username']")).sendKeys("ashishbhalerao824");
//	driver.findElement(By.xpath(".//*[@name='password']")).sendKeys("ashishb8");
//	driver.findElement(By.xpath(".//*[@id='loginForm']/div/div/input")).submit();
	
	@FindBy(xpath= ".//*[@name='username']")
	WebElement userName;
	
	@FindBy(xpath=".//*[@name='password']")
	WebElement passWord;
	
	@FindBy(xpath=".//*[@id='loginForm']/div/div/input")
	WebElement loginButton;
	
	
	@FindBy(xpath="//button[contains(text(), 'Sign Up')]")
	WebElement SignUpBtn;
	
	@FindBy(xpath=".//*[@id='navbar-collapse']//preceding-sibling::div//child::a//child::img") //.//*[@id='navbar-collapse']//preceding-sibling::div//child::a//child::img-----//img[contains(class(), 'img-responsive')]
	WebElement crmLogo;
	
	
	//Initializing the page objects:
	public LoginPage() {
		PageFactory.initElements(driver, this); //Initializing the page factory and this= current class objects
		
		
	}
	
	//Actions:
	public String validateLoginPageTitle() {
		return driver.getTitle();
		
	}
	
	public boolean validateCRMLogoImage() {
		return crmLogo.isDisplayed();
		
	}
	
	public HomePage login(String un, String pwd) {
		userName.sendKeys(un);
		passWord.sendKeys(pwd);
		loginButton.submit();
		
		return new HomePage(); //This method will return HomePage class object
	}
				
	
	}
