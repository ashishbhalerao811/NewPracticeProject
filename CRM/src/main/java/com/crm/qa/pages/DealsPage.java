package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class DealsPage extends TestBase{
	
	TestUtil testUtil;
	DealsPage dealsPage;
	
	@FindBy(xpath="//select[@name='cs_type']")
	WebElement selectType;
	
	//Initialize Page Factory:
	public DealsPage() {
		PageFactory.initElements(driver, this);
		
	}
	
	//Actions:
	public void selectTypeOfDeal() {
		testUtil.select();
		

		}

}
