package com.crm.comcast.pomrepository;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInformation {
	WebDriver driver;
	public OrganizationInformation(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements( driver,this);
}
 @FindBy(className="dvHeaderText")
 private WebElement orgHeaderSucMsg;
 
 @FindBy(id="mouseArea_Industry")
 private WebElement industriesInfo;

 
 public WebElement getOrgHeaderSucMsg() {
	return orgHeaderSucMsg;
}

public WebElement getIndustriesInfo() {
	return industriesInfo;
}
 

}
