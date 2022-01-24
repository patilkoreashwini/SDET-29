package com.crm.comcast.pomrepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewOrganization {
	WebDriver driver;
	public CreateNewOrganization(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements( driver,this);
	}
 
 @FindBy(name="accountname")
 private WebElement orgNameEdt;
 
 @FindBy(name="industry")
 private WebElement industrieslst;
 
 @FindBy(name="accounttype")
 private WebElement typelist;
 
 @FindBy(xpath="//input[@title='Save [Alt+S]']")
 private WebElement saveBtn;
	
	public void createOrg(String orgName,String industries ) 
	{
	orgNameEdt.sendKeys(orgName);
	industrieslst.sendKeys(industries); 
	saveBtn.click();
		
	}
	public void createOrg(String orgName) 
	{
	orgNameEdt.sendKeys(orgName);
	saveBtn.click();
		
	}


	public WebElement getIndustrieslst() {
		return industrieslst;
	}

	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getTypelist() {
		return typelist;
	}

}