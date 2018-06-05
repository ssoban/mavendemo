package com.maventest.automation.uiautomation.actions;


import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.maventest.automation.uiautomation.baseclass.Baseclass;


public class Loginpageactions extends Baseclass
{
	public static Logger logger = Logger.getLogger(Loginpageactions.class.getClass());
    //	WebDriver driver;
	
	public Loginpageactions(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath="/html/body/nav/div/div[2]//*[@id='li_myaccount']/a")
	public WebElement login1;
	
	@FindBy(xpath="/html/body/nav/div/div[2]//*[@id='li_myaccount']/ul/li[1]/a")
	public WebElement login2;
	
	@FindBy(xpath="//*[@id='loginfrm']/div[1]/div[5]/div/div[1]/input")
	public WebElement email;
	//*[@id="loginfrm"]/div[1]/div[5]/div/div[2]/input
	@FindBy(xpath="//input[@type='password']")
	public WebElement password;
	
	@FindBy(xpath="(//*[@type='submit'])[1]")
	public 	WebElement submit;
	@FindBy(xpath=" /html/body/div[8]/div/div//*[@id='loginfrm']/div[1]/div[2]/div")
	public 	WebElement authfail;
	
	@FindBy(xpath="/html/body/div[4]/div/div/div[2]/ul//*[@id='li_myaccount']/a")
	public WebElement login3;
	@FindBy(xpath="/html/body/div[4]/div/div/div[2]/ul//*[@id='li_myaccount']/ul/li[2]/a")
	public WebElement singup;
	@FindBy(xpath="//*[@id='headersignupform']/div[3]/input")
	public WebElement name;
	@FindBy(xpath="//*[@id='headersignupform']/div[4]/input")
	public WebElement lastname;
	@FindBy(xpath="//*[@id='headersignupform']/div[5]/input")
	public WebElement number;
	@FindBy(xpath="//*[@id='headersignupform']/div[6]/input")
	public WebElement email1;
	@FindBy(xpath="//*[@id='headersignupform']/div[7]/input")
	public WebElement pass1;
	@FindBy(xpath="//*[@id='headersignupform']/div[8]/input")
	public WebElement pass2;
	@FindBy(xpath="//*[@id='headersignupform']/div[9]/input")
	public WebElement submit1;
	

	
	public  void loginViaDropDown() {
	
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", login1);
	login1.click();
	log.info("click on object"+login1.toString());
		//WebDriverWait wait = new WebDriverWait(driver, 20); //here, wait time is 20 seconds

		//wait.until(ExpectedConditions.visibilityOf(login1)); //this will wait for elememt to be visible for 20 seconds
	//	login1.click(); //now it clicks on element
		 Actions action = new Actions(driver);
		 
	        action.moveToElement(login1).build().perform();

			  login2.click();
			  log.info("click on object "+login2.toString());
			  
			  
			  
	  
	}
    public void logintoapp(String add, String pass) throws InterruptedException 
    {
    	Thread.sleep(1000);
    //login1.click();
    
    email.sendKeys(add);
    log.info("center email" +add+ "object is"  +email.toString());
    password.sendKeys(pass);
//    log.info("enter password" +pass+ "object is"  +pass.toString());
    submit.click();
    log.info("click on object "+submit.toString());
    }
	
 public String authfailed() throws InterruptedException
 
  {
	 Thread.sleep(1000);
return authfail.getText();

   }
 public void singup(String nam, String lnam, String num, String emal, String pas, String cpass){
	 login3.click();
	 log.info("click on object"+login3.toString());
	 
	 singup.click();
	 log.info("click on object"+singup.toString());
	 name.sendKeys(nam);
	 log.info("enter name" +nam+ "object is"  +name.toString());
	 lastname.sendKeys(lnam);
	 log.info("enter lastname" +lnam+ "object is"  +lastname.toString());
	 number.sendKeys(num);
	 log.info("enter number" +num+ "object is"  +number.toString());
	 email1.sendKeys(emal);
	 log.info("enter email1" +num+ "object is"  +email1.toString());
	 pass1.sendKeys(pas);
	 log.info("enter password" +num+ "object is"  +pass1.toString());
	 pass2.sendKeys(cpass);
	 log.info("enter create confirmpassword" +pass2+ "object is"  +pass2.toString());
	 submit1.click();	
	 log.info("click on object"+submit1.toString());
 }
}