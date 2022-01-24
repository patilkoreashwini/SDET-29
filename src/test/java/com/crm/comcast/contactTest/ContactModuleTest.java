package com.crm.comcast.contactTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.comcast.genericlibrary.BaseClass;
import com.crm.comcast.genericlibrary.ExcelUtility;
import com.crm.comcast.genericlibrary.FileUtility;
import com.crm.comcast.genericlibrary.JavaUtility;
import com.crm.comcast.genericlibrary.WebDriverUtility;
import com.crm.comcast.pomrepository.Contact;
import com.crm.comcast.pomrepository.ContactInformation;
import com.crm.comcast.pomrepository.CreateNewContact;
import com.crm.comcast.pomrepository.CreateNewOrganization;
import com.crm.comcast.pomrepository.Home;
import com.crm.comcast.pomrepository.Login;
import com.crm.comcast.pomrepository.Organization;
import com.crm.comcast.pomrepository.OrganizationInformation;

public class ContactModuleTest extends BaseClass {

	

	@Test(groups= {"smokeTest"})
	public void CreateContactTest() throws Throwable {
	String lastName = elib.getDataFromExcel("contact", 1, 2)+"_"+jlib.getRanDomNumber();
	   //navigate to contact page
	   Home hp=new Home(driver);
	   hp.getContactlink().click();
	   
	   // navigate create new contact page
	   Contact cp=new Contact(driver);
	   cp.getCreateContactImg().click();
	   
	   
	   //create contact
	   CreateNewContact cnp=new CreateNewContact(driver);
	   cnp.createContact(lastName);
	   
	   //verify the contact details
	   ContactInformation ci=new ContactInformation(driver);
	   String actLstName = ci.getOrgHeaderSuchMsg().getText();
	   if(actLstName.contains(lastName)) {
		   System.out.println(lastName+" contact last name is verified & PASS");
	   }
	   else {
		   System.out.println(lastName+" contact last name is not verified & FAIL");
	   }
	 

	}
	
	// 2nd testcase
	@Test(groups= {"regressionTest"})
	public void CreateContactWithOrgTestTest() throws Throwable {
		String lastName = elib.getDataFromExcel("contact", 1, 2)+"_"+jlib.getRanDomNumber();
		 String orgName = elib.getDataFromExcel("org", 1, 2)+"_"+jlib.getRanDomNumber();
		//navigate to organization
		   Home hp=new Home(driver);
		   hp.getOrglink().click();
		   
		   // navigate to org page
			Organization org=new Organization(driver);
			org.getCreateNewOrgImg().click();
			
			// create organization
			CreateNewOrganization cnop=new CreateNewOrganization(driver);
			cnop.createOrg(orgName);
			
			//wait for header element
			OrganizationInformation oi=new OrganizationInformation(driver);
			wlib.waitForElementVisibility(driver,oi.getOrgHeaderSucMsg());
			
			// navigate to contact page
			hp.getContactlink().click();
			
			// navigate to create new contact
			Contact cp= new Contact(driver);
			cp.getCreateContactImg().click();
			
			//create a new contact with orgName page
			CreateNewContact cnp=new CreateNewContact(driver);
			cnp.createContact(lastName, orgName);
			
			
			//verify the details
			ContactInformation ci=new ContactInformation(driver);
			String actName = ci.getOrgHeaderSuchMsg().getText();
			if(actName.contains(lastName)) {
				   System.out.println(lastName+" contact last name is verified & PASS");
			   }
			   else {
				   System.out.println(lastName+" contact last name is not verified & FAIL");
			   }
			
			String actOrgName = ci.getOrgNameInfo().getText();
			if(actOrgName.trim().equals(orgName)) {
				System.out.println(orgName+" is verified in contact page and pass");
			}
			else {
				System.out.println(orgName+" is not verified in contact page and fail");
			}
	}
}
