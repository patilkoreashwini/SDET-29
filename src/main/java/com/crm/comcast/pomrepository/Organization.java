package com.crm.comcast.pomrepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organization {
	WebDriver driver;
	public Organization(WebDriver driver) 
	{
	this.driver=driver;
	PageFactory.initElements( driver,this);

	}
	
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement createNewOrgImg;
	
	@FindBy(xpath="//input[@name='search_text']")
	private WebElement searchEdt;
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement searchBtn;
	

	public WebElement getCreateNewOrgImg() {
		return createNewOrgImg;
	}


	public WebElement getSearchEdt() {
		return searchEdt;
	}


	public WebElement getSearchBtn() {
		return searchBtn;
	}
	
	


}
