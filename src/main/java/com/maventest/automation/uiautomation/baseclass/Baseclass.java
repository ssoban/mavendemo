package com.maventest.automation.uiautomation.baseclass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.maventest.automation.uiautomation.excelreader.Readingexcelsheet;


public class Baseclass
{
	public static Logger log = Logger.getLogger(Baseclass.class.getClass());
	public WebDriver driver;
	String URL="https://www.phptravels.net/";
	String browser="firefox";
	Readingexcelsheet excel;

	public void init() 
	{
		setup(browser);
		navigate();
		String log4jConfPath="log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
		
	 }

	public void setup(String browser)
	{
		
			if(browser.equalsIgnoreCase("firefox"))
			{
				System.out.println(System.getProperty("user.dir"));
			//System.setProperty("webdriver.gecko.driver","C:\\Users\\ssoban\\Downloads\\geckodriver-v0.20.0-win64\\geckodriver.exe");
				System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");
				log.info("creating object of "+browser);
			driver = new FirefoxDriver();
			}
	        else if(browser.equalsIgnoreCase("chrome"))
	        {
	        	System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
			//System.setProperty("webdriver.chrome.driver","/drivers/chromedriver.exe" );
			driver = new ChromeDriver();
			}
			
	}
	public void navigate() 
	{
		    driver.manage().window().maximize();
		    driver.navigate().to(URL);
		    System.out.println("Navigation to url success");
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
	public String[][] getdata(String SheetName,String Excelname) throws IOException{

		String path=System.getProperty("user.dir")+"\\src\\main\\java\\com\\maventest\\automation\\uiautomation\\data\\"+Excelname;
		
			excel = new Readingexcelsheet(path);
		String[][] data = excel.getDataFromSheet(SheetName, Excelname);
		
	
		
		return data;
		
	}

}


/*
public void setup() {
	
	   String key= "webdriver.firefox.marionette";
	   String path= "E:\\geckodriver-v0.15.0-win64\\geckodriver.exe";
	   System.setProperty(key, path);
	   driver = new FirefoxDriver();}
	}
*/
		
