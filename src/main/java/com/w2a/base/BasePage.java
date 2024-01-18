package com.w2a.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.w2a.extentlisteners.ExtentListeners;
import com.w2a.utilities.ExcelReader;


public class BasePage {
	
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static TopMenu menu;
	
	public static Properties OR = new Properties();
	public static Properties Config = new Properties();
	public static FileInputStream fis;
	
	public static Logger logs = Logger.getLogger(BasePage.class.getName());
	public static ExcelReader excel = new ExcelReader(".//src//test//resources//com//w2a//excel//testdata.xlsx");
	//public static ExtentListeners
	
	//Keywords
	public static void click(String key)
	{
		if(key.endsWith("_XPATH"))
		{
			driver.findElement(By.xpath(OR.getProperty(key))).click();
		}
		else if(key.endsWith("_CSS"))
		{
			driver.findElement(By.cssSelector(OR.getProperty(key))).click();
		}
		else if(key.endsWith("_ID"))
		{
			driver.findElement(By.id(OR.getProperty(key))).click();
		}
		
		logs.info("Element "+ key+" is clicked successfully");
		ExtentListeners.test.info("Element "+ key+" is clicked successfully");
	}
	
	
	public static void type(String key, String value)
	{
		if(key.endsWith("_XPATH"))
		{
			driver.findElement(By.xpath(OR.getProperty(key))).sendKeys(value);
		}
		else if(key.endsWith("_CSS"))
		{
			driver.findElement(By.cssSelector(OR.getProperty(key))).sendKeys(value);
		}
		else if(key.endsWith("_ID"))
		{
			driver.findElement(By.id(OR.getProperty(key))).sendKeys(value);
		}
		
		logs.info(value+" is successfully entered into "+key);
		ExtentListeners.test.info(value+" is successfully entered into "+key);
	}
	
	public boolean isElementPresent(By by)
	{
		try
		{
			driver.findElement(by);
			return true;
		}
		catch(NoSuchElementException e)
		{
			return false;
		}
	}
	
	
	public BasePage()
	{
		if(driver == null)
		{
			
			PropertyConfigurator.configure(".//src//test//resources//com//w2a//properties//log4j.properties");
			try {
				fis = new FileInputStream(".//src//test//resources//com//w2a//properties//OR.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				OR.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			logs.info("OR property file loaded successfully");
			
			try {
				fis = new FileInputStream(".//src//test//resources//com//w2a//properties//config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				Config.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			logs.info("Config property file loaded successfully");
			
			
			if(System.getenv("browser")!=null && !System.getenv("browser").isEmpty())
			{
				Config.setProperty("browser", System.getenv("browser"));
			}
			
			if(Config.getProperty("browser").equalsIgnoreCase("chrome"))
			{
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--disable-infobars");
				options.addArguments("--disable-extentions");
				driver = new ChromeDriver(options);
			}
			else if(Config.getProperty("browser").equalsIgnoreCase("edge"))
			{
				driver = new EdgeDriver();
			}
				
			
			driver.get(Config.getProperty("url"));
			
			logs.info("URL- "+Config.getProperty("url")+" is launched successfully");
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(Config.getProperty("implicit_wait"))));
			
			wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(Config.getProperty("explicit_wait"))));
			
			//encapsulation of common pages
			menu = new TopMenu(driver);
			
		}
	}

}
