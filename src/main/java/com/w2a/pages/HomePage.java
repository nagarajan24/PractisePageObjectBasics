package com.w2a.pages;

import org.openqa.selenium.By;

import com.w2a.base.BasePage;

public class HomePage extends BasePage{
	
	public LoginPage goToLogin()
	{
		//wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("/html/body/main/div/div/div[1]/div/div/div[3]/div/div[4]/div/a[1]")))).click();
		click("signin_CSS");
		return new LoginPage();
	}
	
	
	public void goToSignUp()
	{
		driver.findElement(By.linkText("Sign up")).click();
	}

	public void goToCRM()
	{
		driver.findElement(By.cssSelector("li[class='zh-sec-apps zh-crm'] > a > span:last-child >label")).click();
	}
}
