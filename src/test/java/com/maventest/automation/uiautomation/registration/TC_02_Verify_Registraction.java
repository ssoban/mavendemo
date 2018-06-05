package com.maventest.automation.uiautomation.registration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.maventest.automation.uiautomation.actions.Loginpageactions;
import com.maventest.automation.uiautomation.baseclass.Baseclass;

public class TC_02_Verify_Registraction extends Baseclass{
	Loginpageactions singuppage;
	@BeforeClass
	public void setup(){
		init();
	}
	@Test
	public void registernewuser(){
		Loginpageactions singuppage= new Loginpageactions(driver);
		singuppage.singup("soban1", "syed", "7290903438", "emal@gmail.com", "pas12345", "pass12345");
		
	}

}
