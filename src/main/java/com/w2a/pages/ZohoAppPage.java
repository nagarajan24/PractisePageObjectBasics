package com.w2a.pages;

import org.openqa.selenium.By;

import com.w2a.base.BasePage;

public class ZohoAppPage extends BasePage{
	
	
	public CRMPage goToCRM()
	{
		click("crmOption_CSS");
		return new CRMPage();
	}
	
	public void goToBooks()
	{
		driver.findElement(By.xpath("/html/body/main/div/div/div[2]/section[1]/div/div[2]/ul/li[2]/a/span[2]")).click();
	}
	
	public void goToMail()
	{
		driver.findElement(By.xpath("/html/body/main/div/div/div[2]/section[1]/div/div[2]/ul/li[3]/a/span[2]")).click();
	}

}
