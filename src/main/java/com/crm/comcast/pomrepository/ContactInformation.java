package com.crm.comcast.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInformation {
	WebDriver driver;
	public ContactInformation(WebDriver driver)
	{
	this.driver=driver;
	PageFactory.initElements(driver,this);	

	}
	@FindBy(className="dvHeaderText")
	private WebElement orgHeaderSuchMsg;
	
	@FindBy(id="mouseArea_Organization Name")
	private WebElement orgNameInfo;
	
	public WebElement getOrgHeaderSuchMsg() {
		return orgHeaderSuchMsg;
	}

	public WebElement getOrgNameInfo() {
		return orgNameInfo;
	}
	
	


}