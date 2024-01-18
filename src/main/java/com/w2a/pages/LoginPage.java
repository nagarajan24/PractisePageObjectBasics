package com.w2a.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.w2a.base.BasePage;

public class LoginPage extends BasePage{
	
	
	public ZohoAppPage userLogin(String userName, String password)
	{
		type("userid_ID",userName);
		click("nxtBtn_CSS");
		type("password_ID", password);
		click("signinBtn_CSS");
		return new ZohoAppPage();
	}

}
