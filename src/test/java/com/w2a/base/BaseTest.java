package com.w2a.base;

import org.testng.annotations.AfterSuite;

public class BaseTest {

	@AfterSuite
	public void tearDown()
	{
		BasePage.driver.quit();
	}
	
}
