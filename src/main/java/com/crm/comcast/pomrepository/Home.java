package com.crm.comcast.pomrepository;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.genericlibrary.WebDriverUtility;



public class Home extends WebDriverUtility {
	WebDriver driver;

	public Home(WebDriver driver)
	{
	this.driver=driver;
	PageFactory.initElements(driver,this);	

	}
	@FindBy(linkText="Organizations")
	private WebElement orglink;
	
	@FindBy(linkText="Contacts")
	private WebElement contactlink;
   
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement admintmg;
	
    @FindBy(linkText="Sign Out")
    private WebElement signoutlink;

	public WebElement getOrglink() {
		return orglink;
	}

	public WebElement getContactlink() {
		return contactlink;
	}

	public WebElement getAdmintmg() {
		return admintmg;
	}

	public WebElement getSignoutlink() {
		return signoutlink;
	}

  public void logout() 
  {
	  mouseOver(driver,admintmg);
	  signoutlink.click();
	  
  }

}