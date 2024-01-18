package com.w2a.pages;

import org.openqa.selenium.By;

import com.w2a.base.BasePage;

public class CRMPage extends BasePage{
	
	
	public void goToCustomers()
	{
		driver.findElement(By.cssSelector("body > header > div.zw-product-header.zwph-white > div > div.product-nav-links > ul > li.expanded.dropdown.zmenu-customers > span")).click();
	}
	
	public void goToResources()
	{
		driver.findElement(By.xpath("/html/body/header/div[3]/div/div[2]/ul/li[5]/a")).click();
	}
	
	public void goToPricing()
	{
		click("pricing_XPATH");
	}

}
