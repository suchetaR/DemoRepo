package com.crm.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	
	@FindBy(xpath="//td[contains(text(),'User: group automation')]")
	@CacheLookup
	WebElement userNameLable;
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactLinks;
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealslink;
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement taskLinks;
	
	//@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	@FindBy(xpath = "//*[@id=\"navmenu\"]/ul/li[4]/ul/li[1]/a")
	WebElement newContactLink;

	
	public HomePage()
	{
	
		PageFactory.initElements(driver, this);
	}
	public String verifyHomePageTitle()
	{
	return driver.getTitle();
	
	}
	public boolean verifyCorrectUserName()
	{
		 return userNameLable.isDisplayed();
	}
	public ContactsPage ClickonContactsLink()
	{
		contactLinks.click();
		return new ContactsPage();
	}
	public DealsPage clickOnDealsLink()
	{
		dealslink.click();
		return new DealsPage();
	}

	public TasksPage clickOnTasksLink()
	{
		taskLinks.click();
		return new TasksPage();
	}

		public void clickonNewContactLink()
		{
			Actions action=new Actions(driver);
			action.moveToElement(contactLinks).build().perform();
			newContactLink.click();
			
		}
		
		
		
		
		
		
		
		
	
}
