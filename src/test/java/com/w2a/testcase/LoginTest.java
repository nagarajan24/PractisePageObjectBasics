package com.w2a.testcase;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.w2a.base.BaseTest;
import com.w2a.pages.HomePage;
import com.w2a.pages.LoginPage;
import com.w2a.utilities.DataUtil;

public class LoginTest extends BaseTest{
	
	@Test(dataProviderClass = DataUtil.class, dataProvider = "dp")
	public void loginTest(Hashtable<String,String> data)
	{
		HomePage page = new HomePage();
		LoginPage login = page.goToLogin();
		login.userLogin(data.get("username"), data.get("password"));
		
		
//		CRMPage crm = zap.goToCRM();
//		crm.goToPricing();
//		BasePage.menu.goToSurvey();
		
	}
	
	
	

}
