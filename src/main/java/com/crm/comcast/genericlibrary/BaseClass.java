package com.crm.comcast.genericlibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.crm.comcast.pomrepository.Home;
import com.crm.comcast.pomrepository.Login;

public class BaseClass {

	public JavaUtility jlib=new JavaUtility();	
	public WebDriverUtility wlib=new WebDriverUtility();
	public FileUtility flib=new FileUtility();
	public ExcelUtility elib=new ExcelUtility();
	public WebDriver driver=null;
	
	//@Parameters("browser")
	@BeforeClass(groups={"regressionTest","smokeTest"})
	public void configBC(String BROWSER) throws Throwable {
		System.out.println("===launch browser===");
		 // read data from property
	    String USERNAME = flib.getPropertyKeyValue("username");
	    String PASSWORD = flib.getPropertyKeyValue("password");
	    String URL = flib.getPropertyKeyValue("url");
	    String BROWSER1 = flib.getPropertyKeyValue("browser");
	    
	    //read data from excel
	    String lastName = elib.getDataFromExcel("contact", 1, 2)+"_"+jlib.getRanDomNumber();
	    
	    // open browser
	    if(BROWSER1.equals("chrome"))
	    {
	    	driver=new ChromeDriver();
	    }
	    else if ((BROWSER1.equals("firefox")))
	    		{
	    	driver=new FirefoxDriver();
	    	 }
	   // login to app
	   driver.get(URL);
	}
	@BeforeMethod(groups={"regressionTest","smokeTest"})
	public void configBM() throws Throwable {
		
		String USERNAME = flib.getPropertyKeyValue("username");
	    String PASSWORD = flib.getPropertyKeyValue("password");
	    Login lp=new Login(driver);
		   lp.getLogintoApp(USERNAME, PASSWORD);
	}
	
	@AfterMethod(groups={"regressionTest","smokeTest"})
	public void configAM() {
		Home hp=new Home(driver);
		hp.logout();
	}
	@AfterClass(groups={"regressionTest","smokeTest"})
	public void configAC() {
		System.out.println("===close browser===");
		driver.quit();
	}
}