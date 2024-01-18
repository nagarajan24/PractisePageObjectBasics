package com.w2a.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TopMenu {
	
	WebDriver driver;
	
	public TopMenu(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	public void goToSurvey()
	{
		BasePage.click("survey_XPATH");
	}
	
	public void goToCampaigns()
	{
		driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/ul/li[4]/a")).click();
	}

}
