package com.maventest.automation.uiautomation.loginpage;


	


	import org.testng.annotations.Test;

import java.io.IOException;

import org.apache.log4j.Logger;
	import org.testng.Assert;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.maventest.automation.uiautomation.baseclass.Baseclass;
	import com.maventest.automation.uiautomation.actions.Loginpageactions;


	public class TC_02_Verify_multiplecredentials extends Baseclass
	{
		//WebDriver driver;
		
		public static Logger log = Logger.getLogger(TC_02_Verify_multiplecredentials.class.getClass());
		Loginpageactions oginpageactions;
		@DataProvider(name="loginpage")
		public String[][] getTestdata() throws IOException{
			String[][] testrecords=getdata("loginpage","TestData.xlsx");
			return testrecords;
		}
		@BeforeTest
		public void open()
		{
			init();
		}
		
		@Test(dataProvider="loginpage")
		public void verifyinvalidlogin(String add, String pass, String runmode) throws InterruptedException
		{
			System.out.println("error1");
			log.info("..............Starting Test...............");
		oginpageactions   = new Loginpageactions(driver);
			oginpageactions.loginViaDropDown();
			oginpageactions.logintoapp(add, pass);
	
			System.out.println("error12");
		

			
		}
		@AfterTest
		public void endtest()
		{
			driver.close();
			
		}

	}


