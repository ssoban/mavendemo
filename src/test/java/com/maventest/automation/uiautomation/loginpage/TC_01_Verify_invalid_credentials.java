package com.maventest.automation.uiautomation.loginpage;

import org.testng.annotations.Test;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.maventest.automation.uiautomation.baseclass.Baseclass;
import com.maventest.automation.uiautomation.actions.Loginpageactions;


public class TC_01_Verify_invalid_credentials extends Baseclass
{
	//WebDriver driver;
	
	public static Logger log = Logger.getLogger(TC_01_Verify_invalid_credentials.class.getClass());
	Loginpageactions oginpageactions;
	
	@BeforeTest
	public void open()
	{
		init();
	}
	
	@Test
	public void verifyinvalidlogin() throws InterruptedException
	{
		System.out.println("error1");
		log.info("..............Starting Test...............");
	oginpageactions   = new Loginpageactions(driver);
		oginpageactions.loginViaDropDown();
		oginpageactions.logintoapp("emailaddress@com", "userpass123");
	 Assert.assertEquals(oginpageactions.authfailed(), "Invalid Email or Password");
	 
	 log.info("..............Ending Test...............");
		System.out.println("error12");
	

		
	}
	@AfterTest
	public void endtest()
	{
		driver.close();
		
	}

}


//String error=driver.findElement(By.xpath("//span[text()='Email and Password do not match.']")).getText();
		//System.out.println(error);
