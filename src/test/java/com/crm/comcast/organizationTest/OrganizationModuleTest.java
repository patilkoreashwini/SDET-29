package com.crm.comcast.organizationTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.comcast.genericlibrary.BaseClass;
import com.crm.comcast.genericlibrary.ExcelUtility;
import com.crm.comcast.genericlibrary.FileUtility;
import com.crm.comcast.genericlibrary.JavaUtility;
import com.crm.comcast.genericlibrary.WebDriverUtility;
import com.crm.comcast.pomrepository.CreateNewOrganization;
import com.crm.comcast.pomrepository.Home;
import com.crm.comcast.pomrepository.Login;
import com.crm.comcast.pomrepository.Organization;
import com.crm.comcast.pomrepository.OrganizationInformation;

public class OrganizationModuleTest extends BaseClass {
	@Test(groups= {"smokeTest"})
	public void CreateOrgTest() throws Throwable {
		//create objects
	
    String orgName = elib.getDataFromExcel("org", 1, 2)+"-"+jlib.getRanDomNumber();
   
   //navigate to organization
   Home hp=new Home(driver);
   hp.getOrglink().click();
   
   // create organization
	Organization org=new Organization(driver);
	org.getCreateNewOrgImg().click();
	
	CreateNewOrganization cnop=new CreateNewOrganization(driver);
	cnop.createOrg(orgName);
	
	wlib.waitUntilPageLoad(driver);
	OrganizationInformation orgin=new OrganizationInformation(driver);
	String actorgMsg = orgin.getOrgHeaderSucMsg().getText();
	if(actorgMsg.contains(orgName))
	 {
		 System.out.println("organization created successfully==PASS");
	 }
	 else
	 {
		 System.out.println("organization not created successfully==FAIL");
	 }
   

	}
	
	//2nd testcase
	@Test(groups= {"regressionTest"})
	public void CreateOrgWithIndustry() throws Throwable{
		
		String orgName = elib.getDataFromExcel("org", 1, 2)+"_"+jlib.getRanDomNumber();
	    String industries = elib.getDataFromExcel("org", 4, 3);
	    
		 //navigate to organization
		   Home hp=new Home(driver);
		   hp.getOrglink().click();
		   
		   // create organization
			Organization org=new Organization(driver);
			org.getCreateNewOrgImg().click();
			
			//creating organition name with industry
			CreateNewOrganization ctorg=new CreateNewOrganization(driver);
			ctorg.createOrg(orgName, industries);
			
			// verify the org info
			wlib.waitUntilPageLoad(driver);
			OrganizationInformation orgin=new OrganizationInformation(driver);
			String actorgMsg = orgin.getOrgHeaderSucMsg().getText();
			
			if(actorgMsg.contains(orgName))
			 {
				 System.out.println("organization created successfully==PASS");
			 }
			 else
			 {
				 System.out.println("organization not created successfully==FAIL");
			 }
			
		    
			String actIndustryInfo = orgin.getIndustriesInfo().getText();
			if(actIndustryInfo.equals(industries))
			{
				System.out.println("org created with industries successfully==PASS");
			}
			else {
				System.out.println("org not created with industries  successfully==FAIL");
			}
	}
}
    
   