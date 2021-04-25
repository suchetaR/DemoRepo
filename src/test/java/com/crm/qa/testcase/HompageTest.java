package com.crm.qa.testcase;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HompageTest extends TestBase {
LoginPage loginPage;
HomePage homepage;
TestUtil testUtil;
ContactsPage contactsPage;
	public HompageTest()
	{
		super();
		
	}
	@BeforeMethod
	public void setup()
	{
		initialization();
		testUtil=new TestUtil();
contactsPage=new ContactsPage();
		loginPage = new LoginPage();
				homepage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		
	}
	@Test(priority = 1)
	public void verifyHomepageTitleTest()
	{
		String Homeapgetitle=homepage.verifyHomePageTitle();
		Assert.assertEquals(Homeapgetitle, "CRMPRO","Home page title not matched");
	}
	@Test(priority = 2)
	public void verifyusernametest()
	{
		testUtil.switchToFrame();
		Assert.assertTrue(homepage.verifyCorrectUserName());
	}
	@Test(priority=3)
	public void verifyContactsLinkTest(){
		testUtil.switchToFrame();
		contactsPage = homepage.ClickonContactsLink();
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
