package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	//page factory -OR:
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginbutton;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;
	//intiallizing page objects
	//actions
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}

public String validateLoginPageTitle(){
	return driver.getTitle();
}
public boolean validateCRMImage(){
	return crmLogo.isDisplayed();
}
public HomePage login(String un, String pwd){
	username.sendKeys(un);
	password.sendKeys(pwd);
loginbutton.click();
return new HomePage();

}

}