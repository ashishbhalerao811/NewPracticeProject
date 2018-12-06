package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{
	
	@FindBy(xpath=".//td[contains(text(), 'Contacts')]")
	WebElement contactsLabel;
	
	//Part4==>> For Data driven
	@FindBy(id="first_name")
	WebElement firstName;
	
	@FindBy(id="surname")
	WebElement surName;
	
	@FindBy(name="client_lookup")
	WebElement company;
	
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement save;
	
	
	//Initialize Page Factory:
	public ContactsPage() {
		PageFactory.initElements(driver, this);
		
	}
	
	//Actions:
	public boolean verifyContactsLabel() {
		return contactsLabel.isDisplayed();

		}
	
	public void selectContactsByName(String name) {
		//driver.findElement(By.xpath("//a[text()=\"Test Java\"]//parent::td//preceding-sibling::td[@class=\"datalistrow\"]//child::input[@name=\"contact_id\"]")).click();
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td//preceding-sibling::td[@class='datalistrow']//child::input[@name='contact_id']")).click();
	}
	
	//Part4==>> for data driven
	public void createNewContact(String title, String ftName, String ltName, String comp) {
		Select select =new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		
		firstName.sendKeys(ftName);
		surName.sendKeys(ltName);
		company.sendKeys(comp);
		save.click();
		
	}
}
