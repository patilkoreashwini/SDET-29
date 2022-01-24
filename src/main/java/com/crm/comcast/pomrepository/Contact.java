package com.crm.comcast.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contact {
	WebDriver driver;
	public Contact(WebDriver driver)
	{
	this.driver=driver;
	PageFactory.initElements(driver,this);	

	}
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement createContactImg;
	
	public WebElement getCreateContactImg() {
		return createContactImg;
	}
	

}