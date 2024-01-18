package com.w2a.rough;



import com.w2a.base.BasePage;
import com.w2a.pages.CRMPage;
import com.w2a.pages.HomePage;
import com.w2a.pages.LoginPage;
import com.w2a.pages.ZohoAppPage;

public class LoginTest {
	
	
	public static void main(String[] args) {
		
		HomePage page = new HomePage();
		LoginPage login = page.goToLogin();
		ZohoAppPage zap = login.userLogin("nagarajan1719@gmail.com", "nagarajan24");
		CRMPage crm = zap.goToCRM();
		crm.goToPricing();
		BasePage.menu.goToSurvey();
		
		
	}

}
